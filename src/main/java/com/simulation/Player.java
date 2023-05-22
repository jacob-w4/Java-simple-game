package com.simulation;

import javax.swing.*;
import java.util.Objects;

public class Player extends Entity {

    private int[] playerPosition = new int[2];
    private int[] oldPostion = new int[2];
    private ImageIcon playerIcon;
    private int playerMoves;

    public Player() {
        findPlayerPos();
    }

    public void movePlayer(int n, String dir) {
        if (Objects.equals(dir, "x")) {
            if (boardPosition[playerPosition[0]][playerPosition[1] + n] == 0) {
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                playerPosition[1] += n;
            }

        } else if (Objects.equals(dir, "y")) {
            if (boardPosition[playerPosition[0] + n][playerPosition[1]] == 0) {
                oldPostion[0] = playerPosition[0];
                oldPostion[1] = playerPosition[1];
                playerPosition[0] += n;
            }

        }

    }

    public void findPlayerPos() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (boardPosition[i][j] == 2) {
                    playerPosition[1] = i;
                    playerPosition[0] = j;
                }
            }
        }
    }

    public int[] getPlayerPosition() {
        return playerPosition;
    }

    public int[] getOldPostion() {
        return oldPostion;
    }

    public void setPlayerPosition(int[] playerPosition) {
        this.playerPosition = playerPosition;
    }
}
