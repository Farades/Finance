package ru.mtplab.logic;

import java.util.HashSet;

/**
 * Created by TesS on 16.12.2014.
 */
public class Manager implements DataStore {
    private HashSet<User> users;
    public User currentUser;

    public Manager() {
        users = new HashSet<User>();
    }

    //Добавляет пользователя, если такого уже не существует
    public boolean addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }

    public void addAccount(User user, Account account) {

    }

    public void addRecord(Account account, Record record) {

    }

    public boolean checkUser(User user) {
        return users.contains(user);
    }
}
