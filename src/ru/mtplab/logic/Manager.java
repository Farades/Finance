package ru.mtplab.logic;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс Manager - основной класс для управления данными и связи GUI с логикой (контроллер).
 */
public class Manager implements DataStore {
    private Set<User> users;
    public User currentUser;

    public Manager() {
        users = new HashSet<User>();
    }

    //Добавляет пользователя, если такого уже не существует
    @Override
    public boolean addUser(User user) {
        if (users.add(user))
            return true;
        else
            return false;
    }

    @Override
    public void addAccount(User user, Account account) {

    }

    @Override
    public void addRecord(Account account, Record record) {

    }

    public boolean checkUser(User user) {
        if (users.contains(user)) {

        }
        return false;
    }
}
