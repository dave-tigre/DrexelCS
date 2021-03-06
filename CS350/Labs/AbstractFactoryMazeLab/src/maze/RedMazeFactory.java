/**
 * 
 */
package maze;

/**
 * @author dave-tigre
 *
 */
public class RedMazeFactory extends MazeFactory {

	/**
	 * 
	 */
	public RedMazeFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Maze makeMaze()
	{
		return  new Maze();
	}
	
	public Wall makeWall()
	{
		return new RedWall();
	}
	
	public Door makeDoor(Room r1, Room r2)
	{
		return new Door(r1,r2);
	}
	
	public Room makeRoom(int n)
	{
		return new RedRoom(n);
	}
	

}
