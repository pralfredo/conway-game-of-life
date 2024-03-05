// CS231 
// Pramithas Upreti
// Landscape.java
// Section A
// Project 2--> Simulation of Conway's Game of Life 
// 02/17/2023

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Landscape {

    /**
     * The underlying grid of Cells for Conway's Game
     */
    protected Cell[][] landscape;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        this(rows, columns, 0);
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    public Landscape(int rows, int columns, double chance) {
        landscape = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                landscape[i][j] = new Cell();
            }
        }
        initialChance = chance;
        reset();
    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
        for (Cell[] row : landscape) {
            for (Cell cell : row) {
                // Using ThreadLocalRandom to get the random double value
                cell.setAlive(ThreadLocalRandom.current().nextDouble() < initialChance);
            }
        }
    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return landscape.length;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return landscape[0].length;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        String s = "";
        for (Cell[] row : landscape) {
            for (Cell cell : row) {
                s += cell + " ";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>();
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >= 0 && r < getRows() && c >= 0 && c < getCols() && !(r == row && c == col)) {
                    neighbors.add(getCell(r, c));
                }
            }
        }
        return neighbors;
    }

    /**
     * Advances the current Landscape by one step.
     */
    public void advance() {
        Cell[][] tempLandscape = new Cell[getRows()][getCols()]; // A temporary landscape grid is created
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getCols(); c++) {
                // Gets the updated state of each cell. The state of cell changes only when:
                // Alive cells don't have 2||3 alive neighbors, i.e. they die
                // Dead cells have 3 alive neighbors, i.e. they resurrect
                tempLandscape[r][c] = new Cell(getCell(r, c).getAlive()).updateState(getNeighbors(r, c));
            }
        }
        landscape = tempLandscape; // The landscape is advanced
    }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.black : Color.white);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }
}