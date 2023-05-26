package com.simulation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Goblin extends Entity {

    private int[][] goblinPosition = new int[2][2];
    private int[][] goblinOldPosition = new int[2][2];
    private ImageIcon goblinIcon;
    private int goblinHP;
    private int[] goblinPower;
    private int goblinMoves;


    public Goblin() {
        findGoblinPos();
    }

    public void moveGoblin() {
        Random random = new Random();
        for (int i = 0; i < 2; i++) {

            int randomize = random.nextInt(4);
            switch (randomize) {
                case 0 -> {
                    if (boardPosition[goblinPosition[i][0]][goblinPosition[i][1] + 1] == 0) {
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][1] += 1;
                    }
                }
                case 1 -> {
                    if (boardPosition[goblinPosition[i][0] + 1][goblinPosition[i][1]] == 0) {
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][0] += 1;
                    }
                }
                case 2 -> {
                    if (boardPosition[goblinPosition[i][0]][goblinPosition[i][1] - 1] == 0) {
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][1] -= 1;
                    }

                }
                case 3 -> {
                    if (boardPosition[goblinPosition[i][0] - 1][goblinPosition[i][1]] == 0) {
                        goblinOldPosition[i][1] = goblinPosition[i][1];
                        goblinOldPosition[i][0] = goblinPosition[i][0];
                        goblinPosition[i][0] -= 1;
                    }
                }
                default -> {
                    goblinOldPosition[i][1] = goblinPosition[i][1];
                    goblinOldPosition[i][0] = goblinPosition[i][0];
                }
            }
        }
    }

    public void goblinDies() {

    }

    public void initiateFight() {

    }

    ArrayList<Integer[]> positionsOfGoblins = new ArrayList<>();

    public void findGoblinPos() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (boardPosition[i][j] == 4) {
                    //System.out.println(i + " " + j);
                    Integer[] temp = {j, i};
                    //System.out.println(temp[0] + " " + temp[1]);
                    positionsOfGoblins.add(temp);
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            //System.out.print(positionsOfGoblins.get(i)[0]+" ");
            //System.out.println(Arrays.toString(positionsOfGoblins.get(i)));
            goblinPosition[i][0] = positionsOfGoblins.get(i)[0];
            goblinPosition[i][1] = positionsOfGoblins.get(i)[1];
        }
        /*for (int i = 0; i < 10; i++) {
            //System.out.print(positionsOfGoblins.get(i)[0]+" ");
            System.out.println(goblinPosition[i][0] + " " + goblinPosition[i][1]);
        }*/
        //System.out.println(goblinPosition[1][1]);
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
