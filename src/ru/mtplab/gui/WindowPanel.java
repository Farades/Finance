package ru.mtplab.gui;

import ru.mtplab.logic.Manager;

import javax.swing.*;

/**
 * Базовый класс для всех панелей, принадлежащих фрейму FinanceGUI
 */
public class WindowPanel extends JPanel {
    protected JFrame frame;     // Указатель на фрейм нужен для смены текущей панели (костыль или нет?)
    protected Manager manager;  // Менеджер - основной класс для работы с данными. Ака контроллер

    public WindowPanel(Manager manager, JFrame frame) {
        this.frame = frame;
        this.manager = manager;

        setLayout(null);
    }
}
