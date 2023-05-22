package com.simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons implements ActionListener {

    private int buttonsHeigth;
    private int buttonsWidth;

    private JButton up;
    private JButton down;
    private JButton left;
    private JButton right;
    private JPanel buttonMenu;

    public Player player = new Player();

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
        up = new JButton("up");
        down = new JButton("down");
        left = new JButton("left");
        right = new JButton("right");
        buttonMenu = new JPanel();
        buttonMenu.setPreferredSize(new Dimension(buttonsWidth, buttonsHeigth));

        //up.setBounds();
        buttonMenu.add(up);
        buttonMenu.add(down);
        buttonMenu.add(right);
        buttonMenu.add(left);

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
    }

    public void moveLeft() {
        player.movePlayer(-1, "x");
        //int[] i = player.getOldPostion();
        //System.out.println(i[0]);
        //System.out.println(i[1]);
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        show();
        board.refresh();
    }

    public void moveRight() {
        player.movePlayer(1, "x");
        //int[] i = player.getOldPostion();
        //System.out.println(i[0]);
        //System.out.println(i[1]);
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        show();
        board.refresh();
    }

    public void moveUp() {
        player.movePlayer(-1, "y");
        //int[] i = player.getOldPostion();
        //System.out.println(i[0]);
        //System.out.println(i[1]);
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        show();
        board.refresh();
    }

    public void moveDown() {
        player.movePlayer(1, "y");
        int[] i = player.getOldPostion();
        System.out.println(i[0]);
        System.out.println(i[1]);
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        show();
        board.refresh();
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
