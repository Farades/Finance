package ru.mtplab.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by TesS on 16.12.2014.
 */
public class User {

    private DbHelper db;
    private String username;
    private String password;
    private ArrayList<Account> accounts; // Список счетов
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

    public void setAccountsFromDB() {
        
    }
}
