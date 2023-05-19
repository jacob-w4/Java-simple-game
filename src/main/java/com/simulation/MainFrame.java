package com.simulation;

import javax.swing.*;
import java.awt.*;

public class MainFrame  {

    private final static int height = 1100;
    private final static int width = 1100;



    public static void main(String[] args) {

        Settings settings = new Settings(1000, 1000);
        settings.start();
    }

    public void start() {
        JFrame mainFrame = new JFrame("Game");
        mainFrame.setSize(width, height);
        mainFrame.setResizable(false);
        mainFrame.setLocation(505,400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

    }

}