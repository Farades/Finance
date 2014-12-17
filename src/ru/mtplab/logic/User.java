package ru.mtplab.logic;

import java.util.ArrayList;

/**
 * Created by TesS on 16.12.2014.
 */
public class User {
    private String username;
    private String password;
    private ArrayList<Account> accounts; // Список счетов

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        //if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        System.out.println("Equals");
        return true;
    }

    @Override
    public int hashCode() {
        System.out.println("Hash code");
        int result = username != null ? username.hashCode() : 0;
        return result;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
