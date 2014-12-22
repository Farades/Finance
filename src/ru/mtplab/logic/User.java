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
                Account account = new Account();
                account.setDescription(rs.getString(rs.findColumn("DESCR")));
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

    public String[][] getAccountsAsStrings() {
        String[][] res = new String[accounts.size()][2];
        int i = 0;
        for (Account acc : accounts) {
                res[i][0] = acc.getDescription();
                res[i][1] = "0";
        i++;
        }
        return res;
    }
}
