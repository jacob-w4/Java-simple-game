package com.simulation;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private int menuHeight;
    private int menuWidth;

    private JPanel menu;

    private Buttons buttons;

    public Menu(int heigth, int width) {
        menuHeight = heigth;
        menuWidth = width;
        display();
    }

    public void display() {
        menu = new JPanel();
        menu.setPreferredSize(new Dimension(menuWidth,menuHeight));
        buttons = new Buttons(menuHeight,menuWidth);
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
