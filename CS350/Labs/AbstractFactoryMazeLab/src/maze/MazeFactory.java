/**
 * 
 */
package maze;

/**
 * @author dave-tigre
 *
 */
public class MazeFactory {

	/**
	 * 
	 */
	public MazeFactory() {
		// TODO Auto-generated constructor stub
	}

	public Maze makeMaze()
	{
		return  new Maze();
	}
	
	public Wall makeWall()
	{
		return new Wall();
	}
	
	public Door makeDoor(Room r1, Room r2)
	{
		return new Door(r1,r2);
	}
	
	public Room makeRoom(int n)
	{
		return new Room(n);
	}
}
