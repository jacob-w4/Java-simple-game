package com.simulation;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private int menuHeight;
    private int menuWidth;

    private JPanel menu;

    private Buttons buttons;

    private Board board;

    public Menu(int heigth, int width, Board board) {
        menuHeight = heigth;
        menuWidth = width;
        this.board = board;
        display();
    }

    public void display() {
        menu = new JPanel();
        menu.setPreferredSize(new Dimension(menuWidth,menuHeight));
        buttons = new Buttons(menuHeight,menuWidth, board);
        buttons.add(menu);
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
