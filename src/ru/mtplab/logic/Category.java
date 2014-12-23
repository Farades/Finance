package ru.mtplab.logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tess on 23.12.2014.
 */
public class Category {
    private int id;
    private String name;
    private DbHelper db;

    public int getId() {
        return this.id;
    }

    public Category(int id) {
        db = DbHelper.getInstance();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = db.getConn().prepareStatement("SELECT * FROM CATEGORIES WHERE ID=?");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                this.id = id;
                this.name = rs.getString(rs.findColumn("NAME"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DbHelper.closeResource(rs);
            DbHelper.closeResource(statement);
        }
    }

    public String getName() {
        return this.name;
    }
}
