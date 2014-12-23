package ru.mtplab.logic;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by TesS on 16.12.2014.
 */
public class Account {

    private User owner;
    private String description;
    private int id;
    private float balance;
    Set<Record> records;

    public Account(String description, User owner) {
        this.description = description;
        this.owner = owner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecordsFromDB() {

    }

    public User getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
