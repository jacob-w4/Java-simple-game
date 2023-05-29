package com.simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class Buttons implements ActionListener {

    private int buttonsHeigth;
    private int buttonsWidth;
    //private EndScreen endScreen = new EndScreen();
    private JButton up;
    private JButton down;
    private JButton left;
    private JButton right;
    private JPanel buttonMenu;
    static final int[] wall = {18, 1};

    public Player player = new Player();

    public Goblin goblin = new Goblin();

    private Board board;


    public void add(JPanel menu) {
        menu.add(buttonMenu);
    }

    public Buttons(int heigth, int width, Board board) {
        buttonsHeigth = heigth / 2;
        buttonsWidth = width;
        this.board = board;
        start();
    }

    public void start() {
        // Tworzenie przyciskow
        up = new JButton("up");
        down = new JButton("down");
        left = new JButton("left");
        right = new JButton("right");
        // Stworzenie panelu dla przyciskow
        buttonMenu = new JPanel();
        buttonMenu.setPreferredSize(new Dimension(buttonsWidth, buttonsHeigth));

        //up.setBounds();

        // Dodanie przyciskow do panelu
        buttonMenu.add(up);
        buttonMenu.add(down);
        buttonMenu.add(right);
        buttonMenu.add(left);

        // Ustawienie funkcji klikniecia dla przyciskow
        up.addActionListener(this);
        down.addActionListener(this);
        left.addActionListener(this);
        right.addActionListener(this);

    }

    public void show() {
        int[][] tab = board.getFieldStateArray();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void moveLeft() {
        // Zmiana pozycji gracza w lewo
        player.movePlayer(-1, "x");
        // Ustawienie nowej pozycji gracza na planszy
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        for (int i = 0; i < Goblin.amount; i++) {
            if(Math.abs(player.getPlayerPosition()[0]-goblin.getGoblinPosition()[i][1])<=1 && Math.abs(player.getPlayerPosition()[1]-goblin.getGoblinPosition()[i][0])<=1){
                Stats.decreaseHealth();
                if(player.getPlayerPosition()[0] == goblin.getGoblinPosition()[i][1] && player.getPlayerPosition()[1] == goblin.getGoblinPosition()[i][0]){
                    goblin.goblinDies(i);
                    board.changeTo1();
                }
                else {
                    board.changeTo0(goblin.getGoblinPosition()[i]);
                    goblin.goblinDies(i);
                    board.changeTo1();
                }
                Stats.increaseBodyCount();
                board.refresh();
                //board.changeTo1(wall);

            }
        }
        goblin.moveGoblin();
        board.setFieldStateArray2(goblin.getGoblinPosition(), goblin.getGoblinOldPosition());


        board.refresh();
        //board.changeTo1(wall);
        show();
    }

    public void moveRight() {
        // Zmiana pozycji gracza w prawo
        player.movePlayer(1, "x");
        // Ustawienie nowej pozycji gracza na planszy
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        for (int i = 0; i < Goblin.amount; i++) {
            if(Math.abs(player.getPlayerPosition()[0]-goblin.getGoblinPosition()[i][1])<=1 && Math.abs(player.getPlayerPosition()[1]-goblin.getGoblinPosition()[i][0])<=1){
                Stats.decreaseHealth();
                if(player.getPlayerPosition()[0] == goblin.getGoblinPosition()[i][1] && player.getPlayerPosition()[1] == goblin.getGoblinPosition()[i][0]){
                    goblin.goblinDies(i);
                    board.changeTo1();
                }
                else {
                    board.changeTo0(goblin.getGoblinPosition()[i]);
                    goblin.goblinDies(i);
                    board.changeTo1();
                }
                Stats.increaseBodyCount();
                board.refresh();
                //board.changeTo1(wall);
            }
        }
        goblin.moveGoblin();
        board.setFieldStateArray2(goblin.getGoblinPosition(), goblin.getGoblinOldPosition());

        board.refresh();
        //board.changeTo1(wall);
        show();
    }

    public void moveUp() {
        // Zmiana pozycji gracza w gore
        player.movePlayer(-1, "y");
        // Ustawienie nowej pozycji gracza na planszy
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        for (int i = 0; i < Goblin.amount; i++) {
            if(Math.abs(player.getPlayerPosition()[0]-goblin.getGoblinPosition()[i][1])<=1 && Math.abs(player.getPlayerPosition()[1]-goblin.getGoblinPosition()[i][0])<=1){
                Stats.decreaseHealth();

                if(player.getPlayerPosition()[0] == goblin.getGoblinPosition()[i][1] && player.getPlayerPosition()[1] == goblin.getGoblinPosition()[i][0]){
                    goblin.goblinDies(i);
                    board.changeTo1();
                }
                else {
                    board.changeTo0(goblin.getGoblinPosition()[i]);
                    goblin.goblinDies(i);
                    board.changeTo1();
                }
                Stats.increaseBodyCount();
                board.refresh();
                //board.changeTo1(wall);
            }
        }
        goblin.moveGoblin();
        board.setFieldStateArray2(goblin.getGoblinPosition(), goblin.getGoblinOldPosition());

        board.refresh();
        //board.changeTo1(wall);
        show();
    }

    public void moveDown() {
        // Zmiana pozycji gracza w dol
        player.movePlayer(1, "y");
        // Ustawienie nowej pozycji gracza na planszy
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        for (int i = 0; i < Goblin.amount; i++) {
            if(Math.abs(player.getPlayerPosition()[0]-goblin.getGoblinPosition()[i][1])<=1 && Math.abs(player.getPlayerPosition()[1]-goblin.getGoblinPosition()[i][0])<=1){
                Stats.decreaseHealth();
                if(player.getPlayerPosition()[0] == goblin.getGoblinPosition()[i][1] && player.getPlayerPosition()[1] == goblin.getGoblinPosition()[i][0]){
                    goblin.goblinDies(i);
                    board.changeTo1();
                }
                else {
                    board.changeTo0(goblin.getGoblinPosition()[i]);
                    goblin.goblinDies(i);
                    board.changeTo1();
                }
                Stats.increaseBodyCount();
                board.refresh();
                //board.changeTo1(wall);
            }
        }
        goblin.moveGoblin();
        board.setFieldStateArray2(goblin.getGoblinPosition(), goblin.getGoblinOldPosition());

        board.refresh();
        //board.changeTo1(wall);
        show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == up) {
            moveUp();
        } else if (e.getSource() == down) {
            moveDown();
        } else if (e.getSource() == left) {
            moveLeft();
        } else if (e.getSource() == right) {
            moveRight();
        }
    }
}
