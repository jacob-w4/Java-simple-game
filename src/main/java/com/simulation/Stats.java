package com.simulation;

public class Stats {
    private int statsHeight;
    private int statsWidth;
    private static Integer health;
    private int moves;
    private int magicAttacksLeft;
    private int bodyCount;
    private String name;
    private JPanel statsPanel = new JPanel();

    private JLabel nameLabel;

    private static JLabel healthLabel;

    private Settings settings;

    public Stats(Settings settings) {
        this.settings = settings;
        name = settings.getName();

        if (settings.getDifficulty() == 1){
            health = 10;
        }
        if (settings.getDifficulty() == 0) {
            health = 6;
        }
        else if(settings.getDifficulty() == 2){
            health = 6;
        }
        else {
            health = 2;
        }
        nameLabel = new JLabel(name);
        healthLabel = new JLabel(health.toString());
        statsPanel.add(nameLabel);
        statsPanel.add(healthLabel);

    }

    public static void refresh() {

    }
    /*public void start() {
        name = settings.getName();
        if (settings.getDifficulty() == 1){
            health = 10;
        }
        else if(settings.getDifficulty() == 2){
            health = 6;
        }
        else if(settings.getDifficulty() == 3){
            health = 2;
        }
        nameLabel = new JLabel(name);
        healthLabel = new JLabel(health.toString());
        statsPanel.add(nameLabel);
        statsPanel.add(healthLabel);
    }*/

    public void damageHealth(int damage) {

    }

    public void healHealth(int healing) {

    }

    public int getHealth() {
        return health;
    }
    public void gameOver() {

    }

    public int getMagicAttacksLeft() {
        return magicAttacksLeft;
    }

    public String getName() {
        return name;
    }

    public JPanel getStatsPanel() {
        return statsPanel;
    }

    public void setSize(int heigth, int width){
        statsPanel.setPreferredSize(new Dimension(width,heigth));
    }

    public static void increaseHealth(){
        health++;
        healthLabel.setText(health.toString());
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
