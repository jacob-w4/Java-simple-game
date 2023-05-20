package com.simulation;

import javax.swing.*;
import java.awt.*;

public class Buttons {

    private int buttonsHeigth;
    private int buttonsWidth;

    private JButton up;
    private JButton down;
    private JButton left;
    private JButton right;
    private JPanel buttonMenu;

    public void add(JPanel menu) {
        menu.add(buttonMenu);
    }

    public Buttons(int heigth, int width) {
        buttonsHeigth = heigth/2;
        buttonsWidth = width;
        start();
    }
    public void start() {
        up = new JButton("up");
        down = new JButton("down");
        left = new JButton("left");
        right = new JButton("right");
        buttonMenu = new JPanel();
        buttonMenu.setPreferredSize(new Dimension(buttonsWidth, buttonsHeigth));

        //up.setBounds();
        buttonMenu.add(up);
        buttonMenu.add(down);
        buttonMenu.add(right);
        buttonMenu.add(left);

    }
    public void moveLeft(){

    }
    public void moveRight(){

    }
    public void moveUp(){

    }
    public void moveDown(){

    }

}
