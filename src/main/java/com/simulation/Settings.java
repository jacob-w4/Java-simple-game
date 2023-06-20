package com.simulation;

import com.simulation.menu.Stats;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Klasa tworzaca pierwsze okno programu. Zawiera poczatkowe ustawienia gry.
 * @author Jakub, Marek
 * @version 1.2.0
 */
public class Settings implements ActionListener, ChangeListener, KeyListener {
    private final int heigth;
    private final int width;
    private int difficulty;
    private String name;
    private JButton save;
    private JSlider slider;
    private JTextField nameField;
    private JFrame settings;
    private Stats stats;
    private JLabel difficultyLabel;


    /**
     * Przypisuje wartosci poczatkowe.
     * @param heigth wysokosc okna
     * @param width szerokosc okna
     */
    public Settings(int heigth, int width) {
            this.heigth = heigth/2;
            this.width = width/3;
    }

    /**
     * Tworzy okno glowne zawierajace: pole tekstowe, suwak do zmiany poziomu trudnosci gry, oraz przycisk do zapisania wybranych/wpisanych ustawien.
     */
    public void start() {

        // Tworzenie okna ustawien
        settings = new JFrame("Ustawienia");
        settings.setResizable(false);
        settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings.setSize(width,heigth);
        settings.setLayout(new FlowLayout(FlowLayout.TRAILING,width/4,50));


        // Tworzenie pola tekstowego, przycisku do zapisu i suwaka
        nameField = new JTextField();
        save = new JButton("Zapisz");
        slider = new JSlider(1,3);

        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);

        save.setFocusPainted(false);

        // Tworzenie napisow przylegajacych do komponentow
        JLabel nameFieldLabel= new JLabel("Podaj nazwe gracza: ");
        JLabel sliderLabel = new JLabel("Poziom gry: ");
        difficultyLabel = new JLabel("Sredni");

        // Tworzenie paneli
        JPanel namePanel = new JPanel();
        JPanel sliderPanel = new JPanel();

        namePanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        sliderPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        // Dodawanie elementow do okna ustawien
        namePanel.add(nameFieldLabel);
        namePanel.add(nameField);
        sliderPanel.add(sliderLabel);
        sliderPanel.add(slider);
        sliderPanel.add(difficultyLabel);
        settings.add(namePanel);
        settings.add(sliderPanel);
        settings.add(save);

        // Ustawienie rozmiarow komponentow
        slider.setPreferredSize(new Dimension(150,50));
        save.setPreferredSize(new Dimension(200,50));
        nameField.setPreferredSize(new Dimension(200,50));

        // Dodanie funkcjonalnosci do komponentow
        slider.addChangeListener(this);
        save.addActionListener(this);
        nameField.addActionListener(this);
        nameField.addKeyListener(this);
        slider.addKeyListener(this);

        settings.setLocationRelativeTo(null);
        settings.setVisible(true);
    }

    /**
     * @return nazwa gracza
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda zwracajaca poziom trudnosci: <br>
     *  1 - Latwy <br>
     *  2 - Sredni <br>
     *  3 - Trudny
     * @return poziom trudnosci (liczba 1-3)
     */
    public int getDifficulty() {
        return difficulty;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save) {
            // Po kliknieciu przycisku tworzenie okna glownego
            MainFrame mainFrame = new MainFrame();
            name = nameField.getText();
            stats = new Stats(this);
            mainFrame.start(stats);
            settings.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // Zmiana napisu obok suwaka, przy roznych wartosciach
        if (e.getSource() == slider) {
            if(slider.getValue() == 1) {
                difficultyLabel.setText("Latwy ");
                difficulty = 1;
            } else if (slider.getValue() == 2) {
                difficultyLabel.setText("Sredni");
                difficulty = 2;
            } else if (slider.getValue() == 3) {
                difficultyLabel.setText("Trudny");
                difficulty = 3;
            }
        }
        // Przypisanie wartosci z pola tekstowego
        if (e.getSource() == nameField) {
            name = nameField.getText();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Stworzenie okna glownego po kliknieciu przycisku "Enter"
        if (e.getKeyCode()==10) {
            MainFrame mainFrame = new MainFrame();
            name = nameField.getText();
            stats = new Stats(this);
            mainFrame.start(stats);
            settings.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
