package ru.mtplab.gui;

import ru.mtplab.logic.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tess on 23.12.2014.
 */
public class Account extends WindowPanel {

    public Account(final Manager manager, JFrame frame, ru.mtplab.logic.Account account) {
        super(manager, frame);
        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Счет " + "\"" + account + "\"");
        JLabel recordsLabel = new JLabel("Список транзакций:");
        northPanel.add(titleLabel);
        northPanel.add(recordsLabel);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        recordsLabel.setAlignmentX(CENTER_ALIGNMENT);
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
