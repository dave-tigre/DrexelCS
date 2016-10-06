import java.util.Random;
import java.text.DecimalFormat;
import java.awt.Point;
/**
 * @author David Tigreros
 * CS265 Section003 Assignment3
 * Chase.java
 * This class runs the chase simulation.
 * In the simulation the mouse moves randomly along the island (avoiding the
 * cat). As the mouse moves conditions are checked to see if he reaches a
 * bridge to escape, the water and drowns, or if the cat catches the mouse
 * and eats him.
 */
public class Chase{

	/**
	 * Method that runs a single simulation
	 * @param cat the Cat object 
	 * @param mouse the Mouse object
	 * @return the result of the simulation
	 */
	public static String playGame(Cat cat, Mouse mouse){
		
		int[] water = {0, 6}; // location of water on each axis

		// location of 8 bridges (b)
		Point b1 = new Point(0,2);
		Point b2 = new Point(0,4);
		Point b3 = new Point(6,2);
		Point b4 = new Point(6,4);
		Point b5 = new Point(4,6);
		Point b6 = new Point(2,6);
		Point b7 = new Point(4,0);
		Point b8 = new Point(2,0);

		cat.setStartLocation(); // set the starting location of the Cat
		mouse.setStartLocation(); // set the starting location of the Mouse

		/*
		 * ensure the cat and mouse do not start at the same location
		 */
		while(cat.getLocation().equals(mouse.getLocation())){
			mouse.setStartLocation();
		}	

		boolean gameOver = false; // boolean to see if game is over
		
		/*
		 * Run the game until gameOver is true
		 */
		while(!gameOver){
			mouse.move(); // move mouse in random direction
			
			// first ensure mouse does not purposely move to location of cat
			if(mouse.getLocation().equals(cat.getLocation())){
				mouse.move();
			}
			// if mouse location is at any of the bridges->mouse escapes
			else if(mouse.getLocation().equals(b1) ||
				mouse.getLocation().equals(b2) ||
				mouse.getLocation().equals(b3) ||
				mouse.getLocation().equals(b4) ||
				mouse.getLocation().equals(b5) ||
				mouse.getLocation().equals(b6) ||
				mouse.getLocation().equals(b7) ||
				mouse.getLocation().equals(b8)){
				gameOver = true;
				return "b"; // return 'b' for mouse escapes on bridge
			}
			// if mouse hits the x or y axis with no bridge->mouse drowns
			else if( mouse.getLocation().getX() <= water[0]
					|| mouse.getLocation().getX() >= water[1]
					|| mouse.getLocation().getY() <= water[0]
					|| mouse.getLocation().getY() >= water[1]){
					gameOver = true;
					return "w"; // return 'w' for mouse drowns in water
			}

			cat.move(); // cats turn to move

			// if cat is at the location of mouse->cat eats mouse
			if(mouse.getLocation().equals(cat.getLocation())){
				gameOver = true;
				return "c"; // return 'c' for cat eats mouse
			}

		} // end of 'gameOver' while loop
		return "Error: Something broke."; // should not reach this return
	}

	public static void main(String[] args){
		Random rng = new Random();
		Cat cat = new Cat("Sylvester", rng);
		Mouse mouse = new Mouse("Speedy Gonzales", rng);
		Chase test = new Chase();
		int trials = 30; // number of times to run the simulation
		double escapeCount = 0;
		double drownCount = 0;
		double eatenCount = 0;
		String result = null;
		System.out.println("\nCat: " +cat.getName()+ " \t Mouse: "
				+ mouse.getName() + "\nOutcomes:");
		
		// for loop to run the simulation for the amount of trials
		for(int i = 0; i < trials; i++){
			result = test.playGame(cat,mouse);
			switch(result){
				case "c": eatenCount++;
							System.out.println(cat.getName() + " had a snack.");
							continue;
				case "b": escapeCount++;
							 System.out.println(mouse.getName() + " escaped.");
							 continue;
				case "w": drownCount++;
							 System.out.println(mouse.getName() +" drowned.");
							 continue;
			}
		}
			double escapePercent = (escapeCount/trials*100);
			double drownPercent = (drownCount/trials*100);
			double eatenPercent = (eatenCount/trials*100);
			// format decimal output
			DecimalFormat f = new DecimalFormat("##.00"); 
			System.out.println("\nMouse escaped: " + f.format(escapePercent) +
					"% of the time.");
			System.out.println("Mouse drowned: " + f.format(drownPercent) +
					"% of the time.");
			System.out.println("Mouse was eaten: " + f.format(eatenPercent) +
					"% of the time.\n");
	}
}
