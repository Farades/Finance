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

    public final static String TITLE = "Finance";
    public final static int WIDTH = 300;
    public final static int HEIGHT = 500;

    public FinanceGUI() {
        manager = new Manager();
        getContentPane().add(new Welcome(manager, this));
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, WIDTH, HEIGHT);
        setVisible(true);
        setResizable(false);
    }
}
