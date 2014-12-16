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
        welcomeLabel.setBounds(100, 30, 200, 30);
        add(welcomeLabel);
    }
}
