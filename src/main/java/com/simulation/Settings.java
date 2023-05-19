package com.simulation;

import javax.swing.*;
import java.awt.*;


public class Settings extends JFrame{
    private int height;
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

    /*public void start() {
        JFrame settings = new JFrame("Settings");
        settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings.setVisible(true);
        settings.setResizable(false);
        settings.setSize(width,height);
        settings.setLayout(null);


        JTextField name = new JTextField();
        name.setPreferredSize(new Dimension(250, 50));
        JSlider difficultySlider = new JSlider(1,3);
        difficultySlider.setPreferredSize(new Dimension(200,100));

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(475,900,50,50);

        //settings.add(name);
        settings.add(difficultySlider);

        // panel.add(label);
        settings.add(saveButton);
    } */

    public int getHeight() {
        return height;
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
