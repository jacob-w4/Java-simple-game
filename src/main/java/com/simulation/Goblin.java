package com.simulation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Goblin extends Entity {

    public static final int amount = 10;
    private int[][] goblinPosition = new int[amount][2];
    private int[][] goblinOldPosition = new int[amount][2];
    private ImageIcon goblinIcon;
    private int goblinHP;
    private int[] goblinPower;
    private int goblinMoves;


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

    public void initiateFight() {

    }

    ArrayList<Integer[]> positionsOfGoblins = new ArrayList<>();

    public void findGoblinPos() {
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


    public int getGoblinHP() {
        return goblinHP;
    }

    public int getGoblinPower() {
        for (int i : goblinPower
        ) {
            return i;
        }
        return 0; //nie ważne dla wyniku programu, pomijamy to 0 przy implementacji funkcjonalności goblina
    }

    public int[][] getGoblinPosition() {
        return goblinPosition;
    }

    public int[][] getGoblinOldPosition() {
        return goblinOldPosition;
    }
}
