package com.simulation.entities;

import com.simulation.Board;

public abstract class Entity {

    private final Board board = new Board();
    protected int[][] boardPosition = board.getFieldStateArray();


}

