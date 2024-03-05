// CS231 
// Pramithas Upreti
// ConfigurableLifeSimulation.java
// Section A
// Project 2--> Simulation of Conway's Game of Life 
// 02/17/2023

public class ConfigurableLifeSimulation extends LifeSimulation {
	/*
	 * Constructor that inherits properties from LifeSimulation
	 */
	public ConfigurableLifeSimulation() {
		super();
	}

	/**
	 * Modified main function that overrides the one from LifeSimulation
	 */
	public static void main(String[] args) throws InterruptedException, NumberFormatException {

		// The default values for the simulation
		int width = 50;
		int height = 50;
		int timeStep = 250;
		double chance = 0.25;
		int scale = 10;

		try {
			// Prints out the description of the command line arguments, just in case
			System.out
					.println("\nType in command line arguments to change the size, density and scale of the simulation."
							+ "\nThe order of arguments: width height timeStep chance scale\n\n");

			if (args.length > 0)
				height = Integer.parseInt(args[0]);
			if (args.length > 1)
				width = Integer.parseInt(args[1]);
			if (args.length > 2)
				timeStep = Integer.parseInt(args[2]);
			if (args.length > 3)
				chance = Double.parseDouble(args[3]);
			if (args.length > 4) {
				scale = Integer.parseInt(args[4]);
			}
		} catch (NumberFormatException e) { // If the user types strings instead of numbers, uses default values
			System.out.println("The order of arguments : width height timeStep chance scale");
			width = 50;
			height = 50;
			timeStep = 250;
			chance = 0.25;
			scale = 10;
		}

		// The code below is the same as LifeSimulation's main function, however it uses
		// this class
		LifeSimulation simulation = new LifeSimulation(width, height, timeStep, chance, scale);

		while (true) {
			simulation.mainLoop();
		}
	}
}