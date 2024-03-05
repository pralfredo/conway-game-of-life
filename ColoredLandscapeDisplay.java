// CS231 
// Pramithas Upreti
// ColoredLandscapeDisplay.java
// Section A
// Project 2--> Simulation of Conway's Game of Life 
// 02/17/2023

/*
  Originally written by Bruce A. Maxwell a long time ago.
  Updated by Brian Eastwood and Stephanie Taylor more recently
  Updated by Bruce again in Fall 2018

  Creates a window using the JFrame class.

  Creates a drawable area in the window using the JPanel class.

  The JPanel calls the Landscape's draw method to fill in content, so the
  Landscape class needs a draw method.
  
  Students should not *need* to edit anything outside of the main method, 
  but are free to do so if they wish. 
*/

public class ColoredLandscapeDisplay extends LandscapeDisplay {

  /**
   * Essentially uses ColoredLandscape instead of the regular Landscape class in
   * LandscapeDisplay
   */
  public ColoredLandscapeDisplay(ColoredLandscape scape, int scale) {
    super(scape, scale);
  }
}