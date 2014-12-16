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
        background = new Welcome();
        getContentPane().add(background);

        /*
        Жесткий костыль (или нет?). Игорь, вопрос к Вам... :)\
        По идее обработчик нажатия кнопки должен быть в классе Welcome.
        Но тогда из класса Register нельзя вызвать метод getContentPane().add(background);
        Можно конечно в конструкторе Welcome передать ссылку на JFrame, но это совсем уже не торт.
         */
        Welcome welcome = (Welcome) background;
        welcome.register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setRegisterWindow();
            }
        });
    }

    public void setRegisterWindow() {
        background.removeAll();
        background.setVisible(false);
        background = new Register(manager);
        getContentPane().add(background);
    }
}
