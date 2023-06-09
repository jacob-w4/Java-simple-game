package com.simulation.menu;

import com.simulation.EndScreen;
import com.simulation.Settings;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Stats implements ChangeListener {
    private static final EndScreen endScreen = new EndScreen();
    private static Integer health;
    private static Integer bodyCount;
    private static String name;
    private final JPanel statsPanel = new JPanel();

    private static JLabel healthLabel;

    private static JLabel bodyCountLabel;

    public Stats(Settings settings) {
        name = settings.getName();

        if (settings.getDifficulty() == 1) {
            health = 10;
        }
        if (settings.getDifficulty() == 0) {
            health = 6;
        }
        if (settings.getDifficulty() == 2) {
            health = 6;
        }
        if (settings.getDifficulty() == 3) {
            health = 2;
        }
        bodyCount = 0;

        JPanel hpPanel = new JPanel();
        JPanel bcPanel = new JPanel();
        JPanel namePanel = new JPanel();

        JLabel staticHP = new JLabel("Punkty zycia: ");
        JLabel staticBC = new JLabel("Pokonani wrogowie: ");

        bodyCountLabel = new JLabel(bodyCount.toString());
        JLabel nameLabel = new JLabel(name);
        healthLabel = new JLabel(health.toString());

        staticHP.setFont(new Font("Calibri", Font.PLAIN, 22));
        staticBC.setFont(new Font("Calibri", Font.PLAIN, 22));
        bodyCountLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
        healthLabel.setFont(new Font("Calibri", Font.PLAIN, 22));
        nameLabel.setFont(new Font("Calibri", Font.PLAIN, 22));

        hpPanel.add(staticHP);
        hpPanel.add(healthLabel);

        namePanel.add(nameLabel);

        bcPanel.add(staticBC);
        bcPanel.add(bodyCountLabel);

        statsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 2));
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
        health++;
        healthLabel.setText(health.toString());
    }

    public static void decreaseHealth() {
        health--;
        healthLabel.setText(health.toString());
        if (health == 0) {
            endScreen.displayLose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    public static Integer getBodyCount() {
        return bodyCount;
    }

    public static void increaseBodyCount() {
        bodyCount++;
        bodyCountLabel.setText(bodyCount.toString());
    }
}
