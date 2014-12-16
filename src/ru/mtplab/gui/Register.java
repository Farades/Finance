package ru.mtplab.gui;

import ru.mtplab.logic.Manager;

import javax.swing.*;

/**
 * Created by TesS on 16.12.2014.
 */
public class Register extends JPanel {
    private Manager manager;

    public Register(Manager manager) {
        this.manager = manager;

        setLayout(null);
        JLabel welcomeLabel = new JLabel("Регистрация");
        welcomeLabel.setBounds(120, 30, 200, 30);
        add(welcomeLabel);
        addUserInputFields();
    }

    public void addUserInputFields() {
        JTextField userNameInput = new JTextField(20);
        userNameInput.setBounds(100, 120, 150, 30);
        JTextField passwordInput = new JTextField(20);
        passwordInput.setBounds(100, 170, 150, 30);

        JLabel loginLabel = new JLabel("Логин:");
        loginLabel.setBounds(50, 120, 200, 30);
        JLabel passwordLabel = new JLabel("Пароль:");
        passwordLabel.setBounds(37, 170, 200, 30);

        JButton enter = new JButton("Регистрация");
        enter.setBounds(80, 220, 130, 30);

        JButton back = new JButton("Назад");
        back.setBounds(80, 270, 130, 30);

        add(userNameInput);
        add(passwordInput);
        add(loginLabel);
        add(passwordLabel);
        add(enter);
        add(back);
    }
}
