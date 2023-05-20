package com.simulation;

import javax.swing.*;
import java.awt.*;

public class Board{
    private int boardHeigth;
    private int boardWidth;
    private int[][] fieldStateArray;

    private JPanel board;
    public Board(int heigth, int width){
        boardHeigth = heigth;
        boardWidth = width;
        //display();
    }

    public Board() {

    }

    private JButton[][] boardOfButtons;
    public void display() {
        board = new JPanel();
        board.setPreferredSize(new Dimension(boardWidth,boardHeigth));
        boardOfButtons = new JButton[20][20];
        board.setBackground(Color.black);
        board.setLayout(new GridLayout(20,20,2,2));

        for (int i = 0; i<20;i++){
            for (int j = 0; j<20;j++){
                if(fieldStateArray[i][j] == 1){
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.BLACK);
                    board.add(boardOfButtons[i][j]);

                }
                else if(fieldStateArray[i][j] == 2){
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.BLUE);
                    board.add(boardOfButtons[i][j]);
                }
                else if(fieldStateArray[i][j] == 3){
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.YELLOW);
                    board.add(boardOfButtons[i][j]);
                }
                else if(fieldStateArray[i][j] == 4){
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.GREEN);
                    board.add(boardOfButtons[i][j]);
                }
                else if(fieldStateArray[i][j] == 5){
                    boardOfButtons[i][j] = new JButton();
                    boardOfButtons[i][j].setBorderPainted(false);
                    boardOfButtons[i][j].setFocusPainted(false);
                    boardOfButtons[i][j].setBackground(Color.RED);
                    board.add(boardOfButtons[i][j]);
                }
                else{
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

    /*public void createMap(JButton[][] buttons) {
        for (int i=0;i<20;i++){
            for (int j = 0; j<20; j++){
               if(i == 0 || j == 0 || j == 19 || i == 19){
                   buttons[i][j].setBackground(Color.GREEN);
               }
            }
        }
    }*/

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
        /*for (int i=0; i<20; i++){
            for (int j=0; j<20; j++){
                return fieldStateArray[i][j];
            }
        }*/
        return fieldStateArray;
    }
}
