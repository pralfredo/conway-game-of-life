// CS231 
// Pramithas Upreti
// DetectRepetition.java
// Section A
// Project 2--> Simulation of Conway's Game of Life 
// 02/17/2023

public class DetectRepetition extends LifeSimulation {

	/*
	 * Constrcutor that inherits properties from LifeSimulation
	 */
	public DetectRepetition() {
		// Change parameters from here, if necessary
		super();
	}

	/** The constant 5 is set as maximum number of frames to check */
	int MAX_COUNT = 5;
	/** The number of turns that have passed up until last check */
	int repeatCount = 0;
	/** The hallmark landscape we are comparing against */
	String lastScape = "";

	/*
	 * The main function for DetectRepetition
	 */
	public static void main(String[] args) throws InterruptedException {
		DetectRepetition simulation = new DetectRepetition();
		while (true) {
			simulation.mainLoop();
		}
	}

	/*
	 * Overrides the mainLoop from the LifeSimulation
	 */
	@Override
	protected void mainLoop() throws InterruptedException {
		// The normal mainLoop
		Thread.sleep(timeStep);
		scape.advance();
		display.repaint();

		// Checks if the current landscape is the same as lastScape.
		// If it matches, it is considered a repetition
		if (scape.toString().equals(lastScape)) {
			System.out.println("Repetition: Life is a Cycle");
			repeatCount = 0;
		} else {
			repeatCount++; // If it doesn't, the repeat count is increased
		}
		if (repeatCount > MAX_COUNT) { // If the maximum count is passed,
			repeatCount = 0; // resets the repeatCount
			lastScape = scape.toString();
			// and sets the current landscape to be the hallmark landscape for the next
			// turns.
		}
	}
}