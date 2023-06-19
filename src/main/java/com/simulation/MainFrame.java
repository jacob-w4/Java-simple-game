package com.simulation;

import com.simulation.menu.Menu;
import com.simulation.menu.Stats;

import javax.swing.*;
import java.awt.*;


/**
 * Klasa tworząca główne okno programu. Zawiera dwa panele: menu oraz plansze po której toczy się gra.
 * Odpowiedzialna jest również za przekazywanie kolejnym klasom wymiarów.
 * @author Jakub, Marek
 * @version 1.2.0
 */
public class MainFrame  {

    private final static int height = 1000;
    private final static int width = 1666;

    private static JFrame mainFrame;

    private static long startTime;

    /**
     * Rozpoczyna program. Tworzy obiekt klasy Settings i wywołuje funkcje odpowiedzialną za stworzenie pierwszego okna.
     * @see Settings
     */
    public static void main(String[] args) {
        // Utworzenie pierwszego okna programu
        Settings settings = new Settings(height, width);
        settings.start();
        }


    /**
     * Tworzy okno główne gry, składające się z dwóch paneli: planszy oraz menu.
     * @param stats obiekt klasy Stats
     * @see Board
     * @see Menu
     */
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

    /**
     * Zamyka okno główne gry.
     * @see MainFrame
     */
    public static void dispose() {
        mainFrame.dispose();
    }

    /**
     * Metoda zwracająca czas startu gry.
     * Czas zliczany jest od momentu stworzenia głównego okna gry (wywołania funkcji {@link com.simulation.MainFrame#start(Stats)})
     * @return czas startu gry
     */
    public static long getStartTime() {
        return startTime;
    }
}