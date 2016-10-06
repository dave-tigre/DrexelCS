import java.util.Random;
/**
 * @author David Tigreros
 * CS265 Section003 Assignment3
 * Mouse.java
 * Mouse implements Animal Class to create mouse
 */

public class Mouse extends Animal{
	/**
	 * Mouse constructor
	 * @param name mouse's name
	 * @param rng random object
	 */
	public Mouse(String name, Random rng){
		super( name, rng ); //inherits from animal class
	}

	/**
	 * Override move method from Animal Class
	 */
	public void move(){
		double xCoor = location.getX(); // location on x-axis
		double yCoor = location.getY(); // location on y-axis
		String[] directions = {"north", "east", "south", "west"};
		int rand = rng.nextInt(directions.length);
		String direction = directions[rand]; // random direction
		switch(direction){
			case "north": yCoor++;
							  break;
			case "east" : xCoor++;
							  break;
			case "south": yCoor--;
							  break;
			case "west" : xCoor--;
							  break;
		}	
		location.setLocation(xCoor,yCoor); // set new coordinates
	}

}
