// CS231 
// Pramithas Upreti
// ColoredLandscape.java
// Section A
// Project 2--> Simulation of Conway's Game of Life 
// 02/17/2023

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class ColoredLandscape extends Landscape {

    public ColoredLandscape(int rows, int columns, double chance) {
        super(rows, columns, chance);
    }

    /**
     * A class to determine the color of the alive cells.
     * As it essentially represents a sort of heatmap,
     * the cells with less neighbors are colored closer to the top of the rainbow.
     * Cells with a lot of neighbors are colored closer to the bottom of the
     * rainbow.
     * 
     * @param neighbors The neighbors of a given cell
     * 
     * @return an integer that is higher when a cell has more neighbors. maximum
     *         value is 5.
     */
    public int determineColor(ArrayList<Cell> neighbors) {
        int count = 0;
        for (Cell cell : neighbors) {
            if (cell.getAlive())
                count++;
        }
        if (count == 0 || count == 1) {
            return 1; // returns 1 for cells with 0 and 1 neighbors
        } else if (count == 2 || count == 3) {
            return 2; // returns 2 for cells with 2 and 3 neighbors
        } else if (count == 4 || count == 5) {
            return 3; // returns 3 for cells with 4 and 5 neighbors
        } else if (count == 6 || count == 7) {
            return 4; // returns 4 for cells with 6 and 7 neighbors
        } else {
            return 5; // returns 5 for cells with 8 neighbors
        }
    }

    /**
     * Overrides the original draw method from Landscape
     * It still draws the cells as black,
     */
    @Override
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                if (!getCell(x, y).getAlive()) {
                    g.setColor(Color.gray);
                } else {
                    if (determineColor(getNeighbors(x, y)) == 1) {
                        g.setColor(Color.blue); // alive cells with 1 neighbor are blue
                    } else if (determineColor(getNeighbors(x, y)) == 2) {
                        g.setColor(Color.green); // alive cells with 2 or 3 neighbors are green
                    } else if (determineColor(getNeighbors(x, y)) == 3) {
                        g.setColor(Color.yellow); // alive cells with 4 or 5 neighbors are yellow
                    } else if (determineColor(getNeighbors(x, y)) == 4) {
                        g.setColor(Color.orange); // alive cells with 6 or 7 neighbors are orange
                    } else {
                        g.setColor(Color.red); // alive cells with 8 neighbors are red
                    }
                    g.fillOval(x * scale, y * scale, scale, scale);
                }
            }
        }
    }
}