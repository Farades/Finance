package ru.mtplab.logic;

import java.util.ArrayList;

/**
 * Created by TesS on 16.12.2014.
 */
public class Account {

    private String description;
    private float balance;
    ArrayList<Record> records;

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
