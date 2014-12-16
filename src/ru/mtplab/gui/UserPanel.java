package ru.mtplab.gui;

import ru.mtplab.logic.Manager;

import javax.swing.*;

/**
 * Created by TesS on 16.12.2014.
 */
public class UserPanel extends JPanel {
    private JFrame frame;
    private Manager manager;

    public UserPanel(Manager manager, JFrame frame) {
        this.frame = frame;
        this.manager = manager;
        setLayout(null);
        JLabel welcomeLabel = new JLabel("Панель пользователя");
        welcomeLabel.setBounds(120, 30, 200, 30);
        add(welcomeLabel);
    }
}
