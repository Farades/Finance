package ru.mtplab.gui;

import ru.mtplab.logic.Manager;
import ru.mtplab.logic.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by TesS on 16.12.2014.
 */
public class Welcome extends WindowPanel {
    private JLabel authLabel;

    public Welcome(Manager manager, JFrame frame) {
        super(manager, frame);

        Font font = new Font("Arial", Font.BOLD, 14);
        JLabel welcomeLabel = new JLabel("Добро пожаловать в Finance!");
        welcomeLabel.setBounds(60, 30, 200, 30);
        JLabel authLabel = new JLabel("Вы можете войти в свой аккаунт:");
        authLabel.setBounds(50, 120, 200, 30);
        add(welcomeLabel);
        add(authLabel);

        addUserInputFields();
    }

    private void addUserInputFields() {
        final JTextField userNameInput = new JTextField(20);
        userNameInput.setBounds(100, 170, 150, 25);
        final JPasswordField passwordInput = new JPasswordField(20);
        passwordInput.setBounds(100, 220, 150, 25);

        JLabel loginLabel = new JLabel("Логин:");
        loginLabel.setBounds(50, 170, 200, 30);
        JLabel passwordLabel = new JLabel("Пароль:");
        passwordLabel.setBounds(37, 220, 200, 30);

        JButton enter = new JButton("Войти");
        enter.setBounds(80, 270, 130, 30);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(userNameInput.getText(), passwordInput.getText());
                if (manager.checkUser(user)) {
                    System.out.println("Authentication is successful");
                    manager.currentUser = user;
                    setUserPanel();
                } else {
                    System.out.println("login/password incorrected");
                }
            }
        });

        JButton register = new JButton("Регистрация");
        register.setBounds(80, 320, 130, 30);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setRegisterWindow();
            }
        });

        add(userNameInput);
        add(passwordInput);
        add(loginLabel);
        add(passwordLabel);
        add(enter);
        add(register);
    }

    public void setRegisterWindow() {
        removeAll();
        setVisible(false);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new Register(manager, frame));
    }

    public void setUserPanel() {
        removeAll();
        setVisible(false);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new UserPanel(manager, frame));
    }
}