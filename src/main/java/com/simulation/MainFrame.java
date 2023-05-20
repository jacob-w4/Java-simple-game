package com.simulation;

import javax.swing.*;
import java.awt.*;

public class MainFrame  {

    private final static int height = 1000;
    private final static int width = 1000;



    public static void main(String[] args) {
        // Utworzenie pierwszego okna programu
        Settings settings = new Settings(height, width);
        settings.start();
    }

    public void start() {
        // Tworzenie glownego okna
        JFrame mainFrame = new JFrame("Game");
        mainFrame.setResizable(false);
        mainFrame.setLocation(505,400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // Tworzenie planszy i pola menu
        Board board = new Board(height,width*3/5);
        Menu menu = new Menu(height, width*2/5);

        // Dodanie planszy i pola menu do glownego okna
        board.display();
        board.add(mainFrame);
        menu.add(mainFrame);
        menu.display();

        mainFrame.pack();
        mainFrame.setVisible(true);

    }

}