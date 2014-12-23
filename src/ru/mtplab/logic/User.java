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
public class User {

    private DbHelper db;
    private String username;
    private String password;
    public Set<Account> accounts; // Список счетов
    private static Logger logger = LoggerFactory.getLogger(Manager.class);

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        db = DbHelper.getInstance();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return this.username;
    }

    public void setAccountsFromDB() {
        accounts = new HashSet<Account>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = db.getConn().prepareStatement("SELECT * FROM ACCOUNTS WHERE USER_NAME=?");
            statement.setString(1, username);
            rs = statement.executeQuery();
            while (rs.next()) {
                Account account = new Account(rs.getString(rs.findColumn("DESCR")), this);
                accounts.add(account);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DbHelper.closeResource(rs);
            DbHelper.closeResource(statement);
        }
        logger.info("User: {} -> Accounts: {}", this, accounts);
    }

    public void addAccount(Account account) {
        logger.info("Adding Account: {} to User: {}", account, this);

        PreparedStatement statement = null;
        try {
            statement = db.getConn().prepareStatement("INSERT INTO ACCOUNTS (DESCR, USER_NAME) VALUES (?, ?);");
            statement.setString(1, account.getDescription());
            statement.setString(2, account.getOwner().toString());
            int result = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.closeResource(statement);
        }
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

}
