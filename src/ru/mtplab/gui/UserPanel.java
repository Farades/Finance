package ru.mtplab.gui;

import ru.mtplab.logic.Manager;

import javax.swing.*;

/**
 * Created by TesS on 16.12.2014.
 */
public class UserPanel extends WindowPanel {

    public UserPanel(Manager manager, JFrame frame) {
        super(manager, frame);
        JLabel welcomeLabel = new JLabel("Панель пользователя");
        JLabel accountsLabel = new JLabel("Список счетов:");
        String[] columnNames = {
                "Описание",
                "Баланс"
        };
        JTable table = new JTable(manager.currentUser.getAccountsAsStrings(), columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 90, 280, 200);
        welcomeLabel.setBounds(85, 30, 200, 30);
        accountsLabel.setBounds(100, 60, 200, 30);
        add(welcomeLabel);
        add(accountsLabel);
        add(scrollPane);
    }
}
