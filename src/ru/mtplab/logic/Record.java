package ru.mtplab.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by TesS on 16.12.2014.
 */
public class Record {

    private DbHelper db;
    private static Logger logger = LoggerFactory.getLogger(Manager.class);
    private Date date;
    private float amount;
    private String description;
    private Account account;
    private Category category;

    public Record(float amount, String description, Account account, Category category) {
        this.amount = amount;
        this.description = description;
        this.account = account;
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public float getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
