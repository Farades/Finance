package ru.mtplab.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by TesS on 16.12.2014.
 */
public class Welcome extends JPanel{

    public JButton register;

    public Welcome() {
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Добро пожаловать в Finance!");
        welcomeLabel.setBounds(60, 30, 200, 30);
        JLabel authLabel = new JLabel("Вы можете войти в свой аккаунт:");
        authLabel.setBounds(50, 120, 200, 30);
        add(welcomeLabel);
        add(authLabel);

        addUserInputFields();
    }

    private void addUserInputFields() {
        JTextField userNameInput = new JTextField(20);
        userNameInput.setBounds(100, 170, 150, 30);
        JTextField passwordInput = new JTextField(20);
        passwordInput.setBounds(100, 220, 150, 30);

        JLabel loginLabel = new JLabel("Логин:");
        loginLabel.setBounds(50, 170, 200, 30);
        JLabel passwordLabel = new JLabel("Пароль:");
        passwordLabel.setBounds(37, 220, 200, 30);

        JButton enter = new JButton("Войти");
        enter.setBounds(80, 270, 130, 30);

        register = new JButton("Регистрация");
        register.setBounds(80, 320, 130, 30);

        add(userNameInput);
        add(passwordInput);
        add(loginLabel);
        add(passwordLabel);
        add(enter);
        add(register);
    }
}
