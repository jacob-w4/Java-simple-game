package com.simulation;

import javax.swing.*;
import java.awt.*;

public class Board {
    //static final int[] wall = {18, 1};
    private int boardHeigth;
    private int boardWidth;
    private int[][] fieldStateArray = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 1, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 3, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 3, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 4, 0, 1},
            {1, 3, 0, 0, 0, 0, 0, 1, 0, 1, 4, 0, 0, 1, 3, 0, 0, 0, 0, 1},
            {1, 0, 0, 4, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 3, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 4, 0, 0, 0, 1, 0, 1, 0, 4, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1},
            {1, 3, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
            {1, 3, 0, 0, 0, 0, 0, 0, 0, 1, 0, 5, 0, 0, 1, 3, 1, 3, 3, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

    };


    private JPanel board;

    public Board(int heigth, int width) {
        boardHeigth = heigth;
        boardWidth = width;
        //display();
    }

    public Board() {

    }

    private JButton[][] boardOfButtons;

    public void display() {
        board = new JPanel();
        board.setPreferredSize(new Dimension(boardWidth, boardHeigth));
        boardOfButtons = new JButton[20][20];
        board.setBackground(Color.black);
        board.setLayout(new GridLayout(20, 20, 2, 2));

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (fieldStateArray[i][j] == 1) {
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.BLACK);
                    board.add(boardOfButtons[i][j]);

                } else if (fieldStateArray[i][j] == 2) {
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.BLUE);
                    board.add(boardOfButtons[i][j]);
                } else if (fieldStateArray[i][j] == 3) {
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.YELLOW);
                    board.add(boardOfButtons[i][j]);
                } else if (fieldStateArray[i][j] == 4) {
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.GREEN);
                    board.add(boardOfButtons[i][j]);
                } else if (fieldStateArray[i][j] == 5) {
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.RED);
                    board.add(boardOfButtons[i][j]);
                } else {
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.WHITE);
                    board.add(boardOfButtons[i][j]);
                }
            }
        }


        // createMap(boardOfButtons);
        board.setVisible(true);
    }

    public void refresh() {

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (fieldStateArray[i][j] == 1) {
                    boardOfButtons[i][j].setBackground(Color.BLACK);
                }
                if (fieldStateArray[i][j] == 2) {
                    boardOfButtons[i][j].setBackground(Color.BLUE);
                }
                if (fieldStateArray[i][j] == 3) {
                    boardOfButtons[i][j].setBackground(Color.YELLOW);
                }
                if (fieldStateArray[i][j] == 4) {
                    boardOfButtons[i][j].setBackground(Color.GREEN);
                }
                if (fieldStateArray[i][j] == 5) {
                    boardOfButtons[i][j].setBackground(Color.RED);
                }
                if (fieldStateArray[i][j] == 0) {
                    boardOfButtons[i][j].setBackground(Color.WHITE);
                }
            }
        }
        //changeTo1(wall);


        // createMap(boardOfButtons);
        //board.setVisible(true);
    }


    public void add(JFrame mainFrame) {
        mainFrame.add(board);
    }

    public void nextBoard() {

    }

    public int getBoardHeight() {
        return boardHeigth;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int[][] getFieldStateArray() {
        return fieldStateArray;
    }

    public void setFieldStateArray(int[] entityPosition, int[] oldPosition) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                if (i == entityPosition[0] && j == entityPosition[1]) {
                    fieldStateArray[i][j] = 2;
                    fieldStateArray[oldPosition[0]][oldPosition[1]] = 0;
                } else if (i != oldPosition[0] && j != oldPosition[1]) {
                    fieldStateArray[i][j] = fieldStateArray[i][j];
                }
            }
        }
    }
    public void setFieldStateArray2(int[][] entityPositions, int[][] oldPosition) {
        for (int i = 0; i < Goblin.amount; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    if (j == entityPositions[i][0] && k == entityPositions[i][1]) {
                        fieldStateArray[k][j] = 4;
                        fieldStateArray[oldPosition[i][1]][oldPosition[i][0]] = 0;
                        fieldStateArray[0][0] = 1;
                    } else if (j != oldPosition[i][0] && k != oldPosition[i][1]) {
                        fieldStateArray[k][j] = fieldStateArray[k][j];
                    }
                }
            }
        }
    }
    public void changeTo0(int[] position){
        fieldStateArray[position[1]][position[0]] = 0;
    }
    public void changeTo1(){
        fieldStateArray[1][18] = 1;
    }
}
