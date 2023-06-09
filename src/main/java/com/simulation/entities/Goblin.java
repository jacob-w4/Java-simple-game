package com.simulation.entities;

import com.simulation.Board;
import com.simulation.entities.Entity;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Goblin extends Entity {

    public static final int amount = 10;
    private final int[][] goblinPosition = new int[amount][2];
    private final int[][] goblinOldPosition = new int[amount][2];
    private final static ImageIcon goblinIcon = new ImageIcon("src/main/java/res/goblin.png");

    public Goblin() {
        findGoblinPos();
    }

    public void moveGoblin() {
        Random random = new Random();
        int randomize;

        for (int i = 0; i < amount; i++) {

            randomize = random.nextInt(4);
            switch (randomize) {
                case 0 -> {
                    if (boardPosition[goblinPosition[i][1] + 1][goblinPosition[i][0]] == 0 || boardPosition[goblinPosition[i][1] + 1][goblinPosition[i][0]] == 2) {
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][1] += 1;
                    }
                }
                case 1 -> {
                    if (boardPosition[goblinPosition[i][1]][goblinPosition[i][0] + 1] == 0 || boardPosition[goblinPosition[i][1]][goblinPosition[i][0] + 1] == 2) {
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][0] += 1;
                    }
                }
                case 2 -> {
                    if (boardPosition[goblinPosition[i][1] - 1][goblinPosition[i][0]] == 0 || boardPosition[goblinPosition[i][1] - 1][goblinPosition[i][0]] == 2) {
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][1] -= 1;
                    }

                }
                case 3 -> {
                    if (boardPosition[goblinPosition[i][1]][goblinPosition[i][0] - 1] == 0 || boardPosition[goblinPosition[i][1]][goblinPosition[i][0] - 1] == 2) {
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][0] -= 1;
                    }
                }
            }
        }

    }

    public void goblinDies(int i) {
        goblinPosition[i][0] = 18;
        goblinPosition[i][1] = 1;
        goblinOldPosition[i][0] = 18;
        goblinOldPosition[i][1] = 1;
    }

    ArrayList<Integer[]> positionsOfGoblins = new ArrayList<>();

    public void findGoblinPos() {
        if(Board.getCurrentLvL() == 2) {
            boardPosition = Board.getFieldStateArray2();
            positionsOfGoblins.clear();
        }
        if(Board.getCurrentLvL() == 3) {
            boardPosition = Board.getFieldStateArray3();
            positionsOfGoblins.clear();
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (boardPosition[i][j] == 4) {
                    Integer[] temp = {j, i};
                    positionsOfGoblins.add(temp);
                }
            }
        }
        for (int i = 0; i < amount; i++) {
            goblinPosition[i][0] = positionsOfGoblins.get(i)[0];
            goblinPosition[i][1] = positionsOfGoblins.get(i)[1];
        }
    }

    public int[][] getGoblinPosition() {
        return goblinPosition;
    }

    public int[][] getGoblinOldPosition() {
        return goblinOldPosition;
    }
    public static ImageIcon getGoblinIcon() {
        return goblinIcon;
    }
}
