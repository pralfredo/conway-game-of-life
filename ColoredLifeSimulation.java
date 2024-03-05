// CS231 
// Pramithas Upreti
// ColoredLifeSimulation.java
// Section A
// Project 2--> Simulation of Conway's Game of Life 
// 02/17/2023

public class ColoredLifeSimulation {

	/**
	 * The Landscape, which controls the cells
	 */
	protected ColoredLandscape scape;

	/**
	 * The display, which displays the cells
	 */
	protected ColoredLandscapeDisplay display;

	/**
	 * Speed at which turns pass
	 */
	protected int timeStep;

	/**
	 * Constructor that calls the other constructor with default values
	 */
	public ColoredLifeSimulation() {
		this(50, 50, 50, .25, 10); // Default values
	}

	/**
	 * Constructor of ColoredLifeSimulation that creates a landscape and display
	 * 
	 * @param width    the width
	 * @param height   the height
	 * @param timeStep the time step for changing frame
	 * @param chance   the chance for cells to be alive, could be referred as
	 *                 density
	 * @param scale    the scale or size for each cell
	 */
	public ColoredLifeSimulation(int width, int height, int timeStep, double chance, int scale) {
		this.timeStep = timeStep;
		scape = new ColoredLandscape(height, width, chance);
		display = new ColoredLandscapeDisplay(scape, scale);
	}

	/**
	 * The main function of ColoredLifeSimulation
	 * 
	 * @param args the arguments for the simulation
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ColoredLifeSimulation simulation = new ColoredLifeSimulation(); // Create an instance of the simulation
		// Run the simulation until the program closes
		while (true) {
			simulation.mainLoop();
		}
	}

	/**
	 * The Main Loop of the game.
	 * Waits the timeStep, process the turn, and show the cells
	 **/
	protected void mainLoop() throws InterruptedException {
		Thread.sleep(timeStep);
		scape.advance();
		display.repaint();
	}
}