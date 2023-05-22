package com.simulation;

import javax.swing.*;
import java.util.Objects;

public class Player {

    private int[][] playerPosition;
    private ImageIcon playerIcon;
    private int playerMoves;

    public void movePlayer(int n, String dir){
        if(Objects.equals(dir, "x")){
            if (boardPosition[playerPosition[0]][playerPosition[1]+n] == 0){
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                System.out.println(oldPostion[0]);
                System.out.println(oldPostion[1]);
                playerPosition[1]+=n;
            }

        }
        else if(Objects.equals(dir, "y")){
            if (boardPosition[playerPosition[0]+n][playerPosition[1]] == 0){
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                System.out.println(oldPostion[0]);
                System.out.println(oldPostion[1]);
                playerPosition[0]+=n;
            }

        }

    }


}
