package com.simulation;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings implements ActionListener, ChangeListener {
    private int heigth;
    private int width;
    private int difficulty;
    private String name;

    private JButton save;

    private JSlider slider;

    private JTextField nameField;

    private JFrame settings;

    private Stats stats;

    private JLabel difficultyLabel;


    public Settings(int heigth, int width) {
            this.heigth = heigth/2;
            this.width = width/2;

    }

    public void difficultySlider() {

    }


    public void start() {

        // Tworzenie okna ustawien
        settings = new JFrame("Ustawienia");
        settings.setResizable(false);
        settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings.setSize(width,heigth);
        settings.setLayout(new FlowLayout(FlowLayout.TRAILING,width/4,50));
        settings.setLocation(505,400);

        // Tworzenie pola tekstowego, przycisku do zapisu i suwaka
        nameField = new JTextField();
        save = new JButton("Zapisz");
        slider = new JSlider(1,3);

        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);


        // Tworzenie napisow przylegajacych do komponentow
        JLabel nameFieldLabel= new JLabel("Podaj imie: ");
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

        slider.addChangeListener(this);
        save.addActionListener(this);
        nameField.addActionListener(this);

        settings.setVisible(true);
    }


    public int getHeight() {
        return heigth;
    }

    public int getWidth() {
        return width;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void nameToString() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save) {
            //settings.dispose();
            MainFrame mainFrame = new MainFrame();

            //difficulty = slider.getValue();
            name = nameField.getText();
            stats = new Stats(this);
            mainFrame.start(stats);
            settings.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
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
        if (e.getSource() == nameField) {
            name = nameField.getText();
        }
    }

    /*public void addStats(Stats stats) {
        this.stats = stats;
    }*/
}
