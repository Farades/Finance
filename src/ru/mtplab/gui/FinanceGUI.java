package ru.mtplab.gui;

import ru.mtplab.logic.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by TesS on 16.12.2014.
 */
public class FinanceGUI extends JFrame {
    private Manager manager;
    private JPanel background;

    public final static String TITLE = "Finance";
    public final static int WIDTH = 300;
    public final static int HEIGHT = 500;

    public FinanceGUI() {
        background = new JPanel();
        setWelcomeWindow();
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, WIDTH, HEIGHT);
        setVisible(true);
        setResizable(false);
    }

    public void setWelcomeWindow() {
        background.removeAll();
        background.setVisible(false);
        background = new JPanel();
        background.setLayout(null);

        JLabel welcomeLabel = new JLabel("Добро пожаловать в Finance!");
        welcomeLabel.setBounds(60, 30, 200, 30);
        JLabel authLabel = new JLabel("Вы можете войти в свой аккаунт:");
        authLabel.setBounds(50, 120, 200, 30);
        background.add(welcomeLabel);
        background.add(authLabel);

        addUserInputFields();

        getContentPane().add(background);

    }

    public void setRegisterWindow() {
        background.removeAll();
        background.setVisible(false);
        background = new JPanel();
    }

    public void addUserInputFields() {
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

        JButton register = new JButton("Регистрация");
        register.setBounds(80, 320, 130, 30);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setRegisterWindow();
            }
        });

        background.add(userNameInput);
        background.add(passwordInput);
        background.add(loginLabel);
        background.add(passwordLabel);
        background.add(enter);
        background.add(register);
    }
}
