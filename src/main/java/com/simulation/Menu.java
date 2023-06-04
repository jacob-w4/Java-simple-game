package com.simulation;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private int menuHeight;
    private int menuWidth;

    private JPanel menu;

    private Buttons buttons;

    private Stats stats;

    private Board board;

    public Menu(int heigth, int width, Board board, Stats stats) {
        menuHeight = heigth;
        menuWidth = width;
        this.board = board;
        this.stats = stats;
        display();
    }

    public void display() {
        menu = new JPanel();
        menu.setPreferredSize(new Dimension(menuWidth, menuHeight));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(menuWidth, menuHeight/2));
        stats.setSize(menuHeight,menuWidth/2);
        buttons = new Buttons(menuHeight/2, menuWidth, board);
        buttons.add(buttonPanel);

        menu.setLayout(new GridLayout(2,1));
        menu.add(stats.getStatsPanel());
        menu.add(buttonPanel);
        menu.setVisible(true);
    }

    public void add(JFrame mainFrame) {
        mainFrame.add(menu);
    }

    public int getMenuHeight() {
        return menuHeight;
    }

    public int getMenuWidth() {
        return menuWidth;
    }
}
