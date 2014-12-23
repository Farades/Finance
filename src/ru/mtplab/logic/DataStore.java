package ru.mtplab.logic;

import java.util.HashSet;

/**
 * Created by TesS on 16.12.2014.
 */
//    Многие методы логичнее вынести в классы Account, User, Record
//    Что и было сделано...
public interface DataStore {
//    User getUser(String name);
//    Set<Record> getRecords(Account account);

    boolean addUser(User user);
    void addAccount(User user, Account account);
    void addRecord(Account account, Record record);

//    User removeUser(String name);
//    Account removeAccount(User owner, Account account);
//    Record removeRecord(Account from, Record record);
}
