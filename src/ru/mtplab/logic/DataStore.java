package ru.mtplab.logic;

import java.util.HashSet;

/**
 * Created by TesS on 16.12.2014.
 */
//    Многие методы логичнее вынести в классы Account, User, Record
//    Что и было сделано...
public interface DataStore {
    boolean addUser(User user);
    User removeUser(String name);

}
