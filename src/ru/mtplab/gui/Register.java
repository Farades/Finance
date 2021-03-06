package ru.mtplab.gui;

import ru.mtplab.logic.Manager;
import ru.mtplab.logic.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by TesS on 16.12.2014.
 */
public class Register extends WindowPanel {

    private static Logger logger = LoggerFactory.getLogger(Manager.class);

    public Register(Manager manager, JFrame frame) {
        super(manager, frame);

        JLabel welcomeLabel = new JLabel("Регистрация");
        welcomeLabel.setBounds(120, 30, 200, 30);
        add(welcomeLabel);
        addUserInputFields();
    }

    public void addUserInputFields() {
        final JTextField userNameInput = new JTextField(20);
        userNameInput.setBounds(100, 120, 150, 30);
        final JPasswordField passwordInput = new JPasswordField(20);
        passwordInput.setBounds(100, 170, 150, 30);

        JLabel loginLabel = new JLabel("Логин:");
        loginLabel.setBounds(50, 120, 200, 30);
        JLabel passwordLabel = new JLabel("Пароль:");
        passwordLabel.setBounds(37, 170, 200, 30);

        JButton register = new JButton("Регистрация");
        register.setBounds(80, 220, 130, 30);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(userNameInput.getText(), passwordInput.getText());
                manager.addUser(user);
                setWelcomeWindow();
            }
        });


        JButton back = new JButton("Назад");
        back.setBounds(80, 270, 130, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWelcomeWindow();
            }
        });

        add(userNameInput);
        add(passwordInput);
        add(loginLabel);
        add(passwordLabel);
        add(register);
        add(back);
    }

    private void setWelcomeWindow() {
        removeAll();
        setVisible(false);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new Welcome(manager, frame));
    }
}
