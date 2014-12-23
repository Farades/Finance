package ru.mtplab.gui;

import ru.mtplab.logic.Manager;
import ru.mtplab.logic.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tess on 23.12.2014.
 */
public class NewAccount extends WindowPanel {

    public NewAccount(final Manager manager, JFrame frame) {
        super(manager, frame);
        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Добавить новый счет пользователю " + "\"" + manager.currentUser + "\"");
        northPanel.add(titleLabel);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(BorderLayout.NORTH, northPanel);

        JButton back = new JButton("Назад");
        add(BorderLayout.SOUTH, back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUserPanel();
            }
        });
    }

    public void setUserPanel() {
        removeAll();
        setVisible(false);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new UserPanel(manager, frame));
    }
}
