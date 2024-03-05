// CS231 
// Pramithas Upreti
// Cell.java
// Section A
// Project 2--> Simulation of Conway's Game of Life 
// 02/17/2023

import java.util.ArrayList;

public class Cell {

    /**
     * The living/dead state of a Cell
     */
    private boolean state;

    /**
     * Constructer for a cell (it is dead by deafult)
     */
    public Cell() {
        state = false;
    }

    /**
     * Constructs a cell with the specified state.
     * 
     * @param alive a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean alive) {
        state = alive;
    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return state i.e. whether the cell is alive
     */
    public boolean getAlive() {
        return state;
    }

    /**
     * Sets the current state of the cell to the specified state
     * 
     * @param alive is a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean alive) {
        state = alive;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     * @returns the string representation of the updated cell
     */
    public Cell updateState(ArrayList<Cell> neighbors) {
        int count = 0;
        for (Cell cell : neighbors) {
            if (cell.getAlive())
                count++; // Adds to the count if a neighboring cell is alive
        }
        if (this.getAlive()) {
            if (count == 2 || count == 3) {
                state = true; // An alive cell with 2 or 3 alive neighbors remains alive
            } else {
                state = false; // Else it dies
            }
        } else {
            if (count == 3) {
                state = true; // A dead cell with 3 alive neighbors resurrects
            } else {
                state = false; // Else it remains dead
            }
        }
        return new Cell(state); // Returns the string representation of the updated cell
    }

    /**
     * Returns a String representation of a Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        return state ? "1" : "0";
    }
}