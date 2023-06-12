package com.simulation.menu;

import com.simulation.EndScreen;
import com.simulation.Settings;

import javax.swing.*;
import java.awt.*;

public class Stats {
    private static final EndScreen endScreen = new EndScreen();
    private static Integer health;
    private static Integer bodyCount;
    private static String name;
    private final JPanel statsPanel = new JPanel();
    private static JLabel healthLabel;
    private static JLabel bodyCountLabel;

    private static String difficulty;

    public Stats(Settings settings) {
        // Przypisanie nazwy oraz poziomu trudnosci
        name = settings.getName();
        if (settings.getDifficulty() == 1) {
            health = 10;
            difficulty = "Latwy";
        }
        if (settings.getDifficulty() == 0) {
            health = 6;
            difficulty = "Sredni";
        }
        if (settings.getDifficulty() == 2) {
            health = 6;
            difficulty = "Sredni";
        }
        if (settings.getDifficulty() == 3) {
            health = 2;
            difficulty = "Trudny";
        }
        // Przypisanie wartosci początkowej
        bodyCount = 0;

        // Tworznie paneli
        JPanel hpPanel = new JPanel();
        JPanel bcPanel = new JPanel();
        JPanel namePanel = new JPanel();

        // Tworzenie napisow
        JLabel staticHP = new JLabel("Punkty zycia: ");
        JLabel staticBC = new JLabel("Pokonani wrogowie: ");
        bodyCountLabel = new JLabel(bodyCount.toString());
        JLabel nameLabel = new JLabel(name);
        healthLabel = new JLabel(health.toString());

        // Ustawienie czcionki dla napisow
        staticHP.setFont(new Font("Calibri", Font.PLAIN, 22));
        staticBC.setFont(new Font("Calibri", Font.PLAIN, 22));
        bodyCountLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
        healthLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
        nameLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

        // Dodanie poszczegolnych komponentow do paneli
        hpPanel.add(staticHP);
        hpPanel.add(healthLabel);
        namePanel.add(nameLabel);
        bcPanel.add(staticBC);
        bcPanel.add(bodyCountLabel);

        statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 2));

        // Dodanie paneli do panelu glownego
        statsPanel.add(namePanel);
        statsPanel.add(hpPanel);
        statsPanel.add(bcPanel);
    }


    public static String getName() {
        return name;
    }

    public JPanel getStatsPanel() {
        return statsPanel;
    }

    public void setSize(int heigth, int width) {
        statsPanel.setPreferredSize(new Dimension(width, heigth));
    }

    public static void increaseHealth() {
        // Zwiekszanie zycia
        health++;
        healthLabel.setText(health.toString());
    }

    public static void decreaseHealth() {
        // Zmniejszanie zycia
        health--;
        healthLabel.setText(health.toString());
        // Wyswietlenie okna przegranej gdy zycie jest rowne 0
        if (health == 0) {
            endScreen.displayLose();
        }
    }

    public static Integer getBodyCount() {
        return bodyCount;
    }

    public static void increaseBodyCount() {
        // Dodanie pokonanego wroga do licznika
        bodyCount++;
        bodyCountLabel.setText(bodyCount.toString());
    }

    public static String getDifficulty() {
        return difficulty;
    }
}
