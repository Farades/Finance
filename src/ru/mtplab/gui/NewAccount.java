package ru.mtplab.gui;

import ru.mtplab.logic.*;
import ru.mtplab.logic.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tess on 23.12.2014.
 */
public class NewAccount extends WindowPanel {

    private JTextField accountTitle;

    public NewAccount(final Manager manager, JFrame frame) {
        super(manager, frame);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Добавить новый счет пользователю " + "\"" + manager.currentUser + "\"");
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(titleLabel);

        accountTitle = new JTextField(20);
        accountTitle.setMaximumSize(new Dimension(200, 30));
        add(accountTitle);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        JButton back = new JButton("Назад");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUserPanel();
            }
        });
        buttonPanel.add(back);
        JButton addAccountButton = new JButton("Добавить");
        addAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAccount();
            }
        });
        buttonPanel.add(addAccountButton);
        add(buttonPanel);
    }

    public void setUserPanel() {
        removeAll();
        setVisible(false);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new UserPanel(manager, frame));
    }

    public void addAccount() {
        ru.mtplab.logic.Account account = new Account(accountTitle.getText(), manager.currentUser);
        manager.currentUser.addAccount(account);
        manager.currentUser.setAccountsFromDB();
        setUserPanel();
    }
}
