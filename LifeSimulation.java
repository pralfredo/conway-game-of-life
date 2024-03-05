// CS231 
// Pramithas Upreti
// LifeSimulation.java
// Section A
// Project 2--> Simulation of Conway's Game of Life 
// 02/17/2023

public class LifeSimulation {

	/**
	 * The Landscape which controls the cells
	 */
	protected Landscape scape;

	/**
	 * The display, which displays the cells
	 */
	protected LandscapeDisplay display;

	/**
	 * Time steps at which turns pass, protected because it is used in another class
	 */
	protected int timeStep;

	/**
	 * Constructor that calls the other constructor with default values
	 */
	public LifeSimulation() {
		this(50, 50, 250, .25, 10); // Default values
	}

	/**
	 * Constructor for LifeSimulation that creates the scape and display
	 * 
	 * @param width    the width
	 * @param height   the height
	 * @param timeStep the time step for changing frame
	 * @param chance   the chance for cells to be alive, could be referred as
	 *                 density
	 * @param scale    the scale or size for each cell
	 */
	public LifeSimulation(int width, int height, int timeStep, double chance, int scale) {
		this.timeStep = timeStep;
		scape = new Landscape(width, height, chance);
		display = new LandscapeDisplay(scape, scale);
	}

	/**
	 * The main function for LifeSimulation
	 * 
	 * @param args the arguments
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		LifeSimulation simulation = new LifeSimulation(); // Create an instance of the simulation

		// Run the simulation until the program closes
		while (true) {
			simulation.mainLoop();
		}
	}

	/**
	 * The Main Loop of the game.
	 * Wait 250 milliseconds, process the turn, and show the cells
	 **/
	protected void mainLoop() throws InterruptedException {
		Thread.sleep(timeStep); // Length of time to sleep is set as timeStep (which is 250 by default)
								// It's set as timeStep because some extension classes extend LifeSimulation
		scape.advance();
		display.repaint();
	}
}