package com.simulation.entities;

import com.simulation.Board;

/**
 * Klasa abstrakcyjna, zawierajaca pozycje na planszy - przekazuje je klasom dziedziczacym po niej.
 * @author Jakub, Marek
 * @version 1.2.0
 * @see Player
 * @see Goblin
 */
public abstract class Entity {

    private final Board board = new Board();
    protected int[][] boardPosition = board.getFieldStateArray();


}

