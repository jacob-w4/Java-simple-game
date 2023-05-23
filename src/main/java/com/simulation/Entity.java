package com.simulation;

public abstract class Entity {

    private Board board = new Board();
    protected int[][] boardPosition = board.getFieldStateArray();


    public int[][] getBoardPosition() {
        return boardPosition;
    }

    public void deleteEntity() {

    }

    public void show() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(boardPosition[i][j] + " ");
            }
            System.out.println();
        }
    }
}

