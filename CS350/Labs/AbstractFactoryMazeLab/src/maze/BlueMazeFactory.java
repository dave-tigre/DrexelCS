/**
 * 
 */
package maze;

/**
 * @author dave-tigre
 *
 */
public class BlueMazeFactory extends MazeFactory {

	/**
	 * 
	 */
	public BlueMazeFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Maze makeMaze()
	{
		return  new Maze();
	}
	
	public Wall makeWall()
	{
		return new BlueWall();
	}
	
	public Door makeDoor(Room r1, Room r2)
	{
		return new BrownDoor(r1,r2);
	}
	
	public Room makeRoom(int n)
	{
		return new GreenRoom(n);
	}

}
