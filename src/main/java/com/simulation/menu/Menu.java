package com.simulation.menu;

import com.simulation.Board;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private final int menuHeight;
    private final int menuWidth;

    private JPanel menu;

    private final Stats stats;

    private final Board board;

    public Menu(int heigth, int width, Board board, Stats stats) {
        menuHeight = heigth;
        menuWidth = width;
        this.board = board;
        this.stats = stats;
        // Wyswietlenie panelu
        display();
    }

    public void display() {
        // Stworzenie panelu glownego
        menu = new JPanel();
        menu.setPreferredSize(new Dimension(menuWidth, menuHeight));
        // Stworzenie panelu dla przyciskow
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(menuWidth, menuHeight/2));
        stats.setSize(menuHeight,menuWidth/2);
        // Stworzenie przyciskow
        Buttons buttons = new Buttons(menuHeight / 2, menuWidth, board);
        buttons.add(buttonPanel);

        menu.setLayout(new GridLayout(2,1));

        // Dodanie paneli do panelu glownego
        menu.add(stats.getStatsPanel());
        menu.add(buttonPanel);

        menu.setVisible(true);
    }

    public void add(JFrame mainFrame) {
        mainFrame.add(menu);
    }

}
