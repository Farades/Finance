package ru.mtplab.logic;

import java.util.HashSet;

/**
 * Created by TesS on 16.12.2014.
 */
public interface DataStore {
//    User getUser(String name);
//    HashSet<String> getUserNames();
//    HashSet<Account> getAccounts(User owner);
//    HashSet<Record> getRecords(Account account);

    boolean addUser(User user);
    void addAccount(User user, Account account);
    void addRecord(Account account, Record record);

//    User removeUser(String name);
//    Account removeAccount(User owner, Account account);
//    Record removeRecord(Account from, Record record);
}
