package ru.mtplab.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mtplab.logic.Account;
import ru.mtplab.logic.Manager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by TesS on 16.12.2014.
 */
public class UserPanel extends WindowPanel {

    private static Logger logger = LoggerFactory.getLogger(Manager.class);

    public UserPanel(final Manager manager, JFrame frame) {
        super(manager, frame);
        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        JLabel welcomeLabel = new JLabel("Панель пользователя " + manager.currentUser);
        JLabel accountsLabel = new JLabel("Список счетов:");
        northPanel.add(welcomeLabel);
        northPanel.add(accountsLabel);
        welcomeLabel.setAlignmentX(CENTER_ALIGNMENT);
        accountsLabel.setAlignmentX(CENTER_ALIGNMENT);

        Vector<Account> accountsVector = new Vector<Account>();
        accountsVector.addAll(manager.currentUser.getAccounts());
        final JList accountsList = new JList(accountsVector);
        accountsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                setAccountWindow((Account)accountsList.getSelectedValue());
            }
        });

        add(BorderLayout.NORTH, northPanel);
        add(BorderLayout.CENTER, new JScrollPane(accountsList));

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        JButton logout = new JButton("Выход");
        JButton addButton = new JButton("Добавить счет");
        JButton delButton = new JButton("Удалить счет");
        Font buttonFont = new Font("Arial", Font.PLAIN, 12);
        logout.setFont(buttonFont);
        addButton.setFont(buttonFont);
        delButton.setFont(buttonFont);
        southPanel.add(logout);
        southPanel.add(addButton);
        southPanel.add(delButton);
        add(BorderLayout.SOUTH, southPanel);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("Logout from user: {}", manager.currentUser);
                manager.currentUser = null;
                setWelcomeWindow();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNewAccountWindow();
            }
        });
    }

    private void setWelcomeWindow() {
        removeAll();
        setVisible(false);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new Welcome(manager, frame));
    }

    private void setAccountWindow(Account acc) {
        removeAll();
        setVisible(false);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new ru.mtplab.gui.Account(manager, frame, acc));
    }

    private void setNewAccountWindow() {
        removeAll();
        setVisible(false);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new NewAccount(manager, frame));
    }
}
