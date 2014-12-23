package ru.mtplab.gui;

import ru.mtplab.logic.Manager;
import ru.mtplab.logic.Record;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tess on 23.12.2014.
 */
public class Account extends WindowPanel {

    private ru.mtplab.logic.Account account;

    public Account(final Manager manager, JFrame frame, ru.mtplab.logic.Account account) {
        super(manager, frame);
        this.account = account;
        account.setRecordsFromDB();
        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel(manager.currentUser.toString() + " - Счет " + "\"" + account + "\"");
        JLabel recordsLabel = new JLabel("Список транзакций:");
        northPanel.add(titleLabel);
        northPanel.add(recordsLabel);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        recordsLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(BorderLayout.NORTH, northPanel);

        TableModel model = new RecordsTableModel(account.getRecords());
        JTable recordsTable = new JTable(model);
        add(BorderLayout.CENTER, new JScrollPane(recordsTable));

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

    public class RecordsTableModel implements TableModel {

        private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
        private ArrayList<Record> recordList;

        public RecordsTableModel(Set<Record> recordSet) {
            this.recordList = new ArrayList<Record>(recordSet);
        }

        public void addTableModelListener(TableModelListener listener) {
            listeners.add(listener);
        }

        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        public int getColumnCount() {
            return 3;
        }

        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Описание";
                case 1:
                    return "Сумма";
                case 2:
                    return "Категория";
            }
            return "";
        }

        public int getRowCount() {
            return account.getRecords().size();
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            Record record = recordList.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return record.getDescription();
                case 1:
                    return String.valueOf(record.getAmount());
                case 2:
                    return record.getCategory().getName();
            }
            return "";
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        public void removeTableModelListener(TableModelListener listener) {
            listeners.remove(listener);
        }

        public void setValueAt(Object value, int rowIndex, int columnIndex) {

        }

    }
}
