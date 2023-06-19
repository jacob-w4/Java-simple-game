package com.simulation.entities;

import com.simulation.Board;
import com.simulation.menu.Buttons;
import com.simulation.EndScreen;
import com.simulation.menu.Stats;

import javax.swing.*;
import java.util.Objects;

/**
 * Klasa dziedzicząca po klasie {@link Entity}. Odpowiada za graficzną reprezentację gracza na planszy.
 * Razem z klasą {@link Buttons} umożliwia poruszanie się za pomocą przycisków oraz klawiszy WASD.
 */
public class Player extends Entity {

    private final int[] playerPosition = new int[2];
    private final int[] oldPostion = new int[2];
    private final static ImageIcon playerIcon = new ImageIcon("src/main/java/res/miner64.png");
    private final EndScreen endScreen = new EndScreen();

    /**
     * Konstruktor klasy {@link Player}, odpowiedzialny za znalezienie pozycji gracza na planszy (tablicy dwuwymiarowej).
     * @see Player#findPlayerPos()
     */
    public Player() {
        findPlayerPos();
    }

    /**
     * Zmienia pozycje gracza zgodnie z podanymi parametrami. Gracz może poruszać się w cztery strony -
     * np. podając parametry: x = -1 , dir = "x" poruszamy graczem o jedno pole w lewo.
     * Ponadto, po wejściu na określone pole (o odpowiedniej cyfrze) wykonywana jest następująca czynność: <br>
     * 3 - życie - {@link Stats#increaseHealth()}<br>
     * 5,6 - diament - {@link Buttons#nextLvl()} <br>
     * 7 - puchar - {@link EndScreen#displayWin()}
     * @param n ilość pól (1 lub -1)
     * @param dir kierunek ("x" lub "y")
     */
    public void movePlayer(int n, String dir) {
        if (Objects.equals(dir, "x")) {
            // Zmiana pozycji x'owej gracza jezeli pole ma wartosc 0
            if (boardPosition[playerPosition[0]][playerPosition[1] + n] == 0 || boardPosition[playerPosition[0]][playerPosition[1] + n] == 4) {
                // Przypisanie starej pozycji
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                // Ustawienie nowej pozycji
                playerPosition[1] += n;

            } else if (boardPosition[playerPosition[0]][playerPosition[1] + n] == 3) {
                // Przypisanie starej pozycji
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                // Ustawienie nowej pozycji
                playerPosition[1] += n;
                // Dodanie zycia do statystyk
                Stats.increaseHealth();

                // Przejscie na drugą plansze
            } else if (boardPosition[playerPosition[0]][playerPosition[1] + n] == 5) {
                Board.setCurrentLvL(2);
                boardPosition = Board.getFieldStateArray2();
                Buttons.nextLvl();
                // Przejscie na trzecia plansze
            } else if (boardPosition[playerPosition[0]][playerPosition[1] + n] == 6) {
                Board.setCurrentLvL(3);
                boardPosition = Board.getFieldStateArray3();
                Buttons.nextLvl();
                // Wyswietlenie okna wygranej
            } else if (boardPosition[playerPosition[0]][playerPosition[1] + n] == 7) {
                endScreen.displayWin();
            }

        } else if (Objects.equals(dir, "y")) {
            // Zmiana pozycji y'owej gracza jezeli pole ma wartosc 0
            if (boardPosition[playerPosition[0] + n][playerPosition[1]] == 0 || boardPosition[playerPosition[0] + n][playerPosition[1]] == 4) {
                // Przypisanie starej pozycji
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                // Ustawienie nowej pozycji
                playerPosition[0] += n;
            } else if (boardPosition[playerPosition[0] + n][playerPosition[1]] == 3) {
                // Przypisanie starej pozycji
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                // Ustawienie nowej pozycji
                playerPosition[0] += n;
                // Dodanie zycia do statystyk
                Stats.increaseHealth();

                // Przejscie na drugą plansze
            } else if (boardPosition[playerPosition[0] + n][playerPosition[1]] == 5) {
                Board.setCurrentLvL(2);
                boardPosition = Board.getFieldStateArray2();
                Buttons.nextLvl();

                // Przejscie na trzecia plansze
            } else if (boardPosition[playerPosition[0] + n][playerPosition[1]] == 6) {
                Board.setCurrentLvL(3);
                boardPosition = Board.getFieldStateArray3();
                Buttons.nextLvl();

                // Wyswietlenie okna wygranej
            } else if (boardPosition[playerPosition[0] + n][playerPosition[1]] == 7) {
                endScreen.displayWin();
            }
        } else {
            oldPostion[0] = playerPosition[0];
            oldPostion[1] = playerPosition[1];
        }
    }

    /**
     * Znajduje pozycje gracza na planszy i przypisuje ją do zmiennej w postaci tablicy dwuelementowej, gdzie
     * pierwszy element to pozycja na 'y' ,a drugi na 'x'.
     */
    public void findPlayerPos() {
        // Szukanie pozycji gracza (2) na planszy i przypisanie do zmiennej
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (boardPosition[i][j] == 2) {
                    playerPosition[0] = i;
                    playerPosition[1] = j;
                }
            }
        }
    }

    /**
     * @return pozycja gracz - tablica dwuelementowa
     * @see Player#findPlayerPos()
     */
    public int[] getPlayerPosition() {
        return playerPosition;
    }

    /**
     * @return stara pozycja gracza - tablica dwuelemetowa
     */
    public int[] getOldPostion() {
        return oldPostion;
    }

    /**
     * Graficzna reprezentacja gracza.
     * @return ikona gracza
     */
    public static ImageIcon getPlayerIcon() {
        return playerIcon;
    }
}
