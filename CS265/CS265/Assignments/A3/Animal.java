import java.awt.Point;
import java.util.Random;

/**
 * @author David Tigreros
 * CS265 Section003 Assignment3
 * Animal.java
 * Abstract class for animals (cat, mouse)
 */
public abstract class Animal{
	protected Point location = new Point(); // location of the animal
	private String name; // string for animal name
	public Random rng; // random number generator object

	/**
	 * Animal class constructor to set animal name and location
	 * @param name the name of the animal
	 * @param rng random number for start location
	 */
	public Animal(String name, Random rng){
		this.name = name;
		this.rng = rng;
	}

	/**
	 * Get the name of the animal
	 * @return the name of the animal
	 */
	public String getName(){
		return name;
	}

	/**
	 * Get location of the animal
	 * @return animal location
	 */ 
	public Point getLocation(){
		return location;
	}

	/**
	 * Set the start location of the animal
	 * @param coor Point for the starting location
	 */
	public void setStartLocation(){
		int x = rng.nextInt(5) + 1; // x coordinate
		int y = rng.nextInt(5) + 1; // y coordinate
		location.setLocation(x,y); // set location to random coordinates
	}
	
	/**
	 * Abstract method to override for moving
	 */ 
	abstract void move();
}	
