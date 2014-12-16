package ru.mtplab.logic;

import java.util.ArrayList;

/**
 * Created by TesS on 16.12.2014.
 */
public class User {
    private String username;
    private String password;
    private ArrayList<Account> accounts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
