import java.util.Random;
/**
 * @author David Tigreros
 * CS265 Section003 Assignment3
 * Cat.java
 * Cat class extends abstract animal class 
 */
public class Cat extends Animal{
	/**
	 * Cat class constructor
	 * @param name name of the cat 
	 * @param rng random number object
	 */
	public Cat(String name, Random rng){
		super( name, rng ); //inherits name and random num gen from animal class
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
		// ensure that cat is confined to the island borders
		if((0 < xCoor && xCoor < 6) && (0 < yCoor && yCoor < 6))
		{
			location.setLocation(xCoor, yCoor); // set new coordinates
		}
		else{
			move(); //if coordinates are not in island, recall the method
		}

	}
}

