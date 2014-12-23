package ru.mtplab.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by TesS on 16.12.2014.
 */
public class Account {

    private static Logger logger = LoggerFactory.getLogger(Manager.class);
    private DbHelper db;
    private User owner;
    private String description;
    private int id;
    private float balance;
    Set<Record> records;

    public Account(String description, User owner) {
        this.description = description;
        this.owner = owner;
        db = DbHelper.getInstance();
    }

    public Account(String description, User owner, int id) {
        this(description, owner);
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public User getOwner() {
        return owner;
    }

    public int getId() {
        return this.id;
    }

    public void setRecordsFromDB() {
        records = new HashSet<Record>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = db.getConn().prepareStatement("SELECT * FROM RECORDS WHERE ACCOUNT_ID=?;");
            statement.setInt(1, this.id);
            rs = statement.executeQuery();
            while (rs.next()) {
                float amount = rs.getFloat(rs.findColumn("AMOUNT"));
                String description = rs.getString(rs.findColumn("DESCR"));
                Category category = new Category(rs.getInt(rs.findColumn("CATEGORY_ID")));
                Record record = new Record(amount, description, this, category);
                records.add(record);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DbHelper.closeResource(rs);
            DbHelper.closeResource(statement);
        }
        logger.info("Account: {} -> Records: {}", this, records);
    }

    @Override
    public String toString() {
        return this.description;
    }
}
