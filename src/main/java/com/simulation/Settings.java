package com.simulation;

import javax.swing.*;
import java.awt.*;


public class Settings implements ActionListener {
    private int heigth;
    private int width;
    private float difficulty;
    private String name;



    public Settings() {


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(1000,1000);


        //JTextField name = new JTextField();
        //name.setPreferredSize(new Dimension(250, 50));
        //JSlider difficultySlider = new JSlider(1,3);
        //difficultySlider.setPreferredSize(new Dimension(200,100));


        //JButton saveButton = new JButton("Save");
        //saveButton.setBounds(175,150,50,50);

        //settings.add(name);
        //add(difficultySlider);

        // panel.add(label);
        //add(saveButton);

    }

    public void difficultySlider() {

    }


    public void start() {

        // Tworzenie okna ustawien
        settings = new JFrame("Ustawienia");
        settings.setResizable(false);
        settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings.setSize(width,heigth);
        settings.setLayout(new FlowLayout(FlowLayout.TRAILING,width/3,50));
        settings.setLocation(505,400);

        // Tworzenie pola tekstowego, przycisku do zapisu i suwaka
        nameField = new JTextField();
        save = new JButton("Zapisz");
        slider = new JSlider(1,3);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        save.addActionListener(this);

        // Tworzenie napisow przylegajacych do komponentow
        JLabel nameFieldLabel= new JLabel("Podaj imie: ");
        JLabel sliderLabel = new JLabel("Poziom gry: ");
        JLabel difficultyLabel = new JLabel("   Sredni");

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
        slider.setPreferredSize(new Dimension(260,50));
        save.setPreferredSize(new Dimension(260,50));
        nameField.setPreferredSize(new Dimension(300,50));


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

    public float getDifficulty() {
        return difficulty;
    }

    public void nameToString() {

    }
}
