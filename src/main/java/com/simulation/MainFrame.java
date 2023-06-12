package com.simulation;

import com.simulation.menu.Menu;
import com.simulation.menu.Stats;

import javax.swing.*;
import java.awt.*;


public class MainFrame  {

    private final static int height = 1000;
    private final static int width = 1666;

    private static JFrame mainFrame;

    private static long startTime;

    public static void main(String[] args) {
        // Utworzenie pierwszego okna programu
        Settings settings = new Settings(height, width);
        settings.start();
        }


    public void start(Stats stats) {
        // Tworzenie glownego okna
        mainFrame = new JFrame("Game");
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dodanie layout'u
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // Tworzenie planszy
        Board board = new Board(height,width*3/5);

        // Dodanie planszy do glownego okna
        board.display();
        board.add(mainFrame);

        // Tworzenie pola menu
        com.simulation.menu.Menu menu = new Menu(height, width*2/5, board, stats);

        // Dodanie pola menu do glownego okna
        menu.add(mainFrame);

        // Połączenie paneli w całość
        mainFrame.pack();

        // Wyswietlenie okna na środku ekranu
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        // Start liczenia czasu gry
        startTime = System.currentTimeMillis();

    }

    public static void dispose() {
        mainFrame.dispose();
    }

    public static long getStartTime() {
        return startTime;
    }
}