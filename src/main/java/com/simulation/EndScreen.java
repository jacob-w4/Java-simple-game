package com.simulation;

import javax.swing.*;
import java.awt.*;

public class EndScreen {

    public void displayWin() {
        JFrame endScreen = new JFrame();
        endScreen.setSize(new Dimension(420, 420));
        endScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        endScreen.setResizable(false);
        JLabel winLabel = new JLabel("You Won! \n");
        //endScreen.add(winLabel);
        JPanel winPanel = new JPanel();
        JLabel bodyCount = new JLabel(Stats.getBodyCount().toString());
        JLabel nameLabel = new JLabel(Stats.getName());
        winPanel.add(winLabel);
        winPanel.add(bodyCount);
        winPanel.add(nameLabel);
        endScreen.add(winPanel);
        MainFrame.dispose();
        endScreen.setLocationRelativeTo(null);
        endScreen.setVisible(true);
    }
    public void displayLose() {
        JFrame endScreen = new JFrame();
        endScreen.setSize(new Dimension(420, 420));
        endScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        endScreen.setResizable(false);
        JLabel winLabel = new JLabel("You Lost! \n");
        JPanel winPanel = new JPanel();
        JLabel bodyCount = new JLabel(Stats.getBodyCount().toString());
        JLabel nameLabel = new JLabel(Stats.getName());
        winPanel.add(winLabel);
        winPanel.add(bodyCount);
        winPanel.add(nameLabel);
        endScreen.add(winPanel);
        MainFrame.dispose();
        endScreen.setLocationRelativeTo(null);
        endScreen.setVisible(true);
    }
}
