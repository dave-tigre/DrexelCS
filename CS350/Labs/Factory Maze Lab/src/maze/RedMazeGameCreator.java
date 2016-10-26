/**
 * 
 */
package maze;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import maze.ui.MazeViewer;

/**
 * @author dave-tigre
 *
 */
public class RedMazeGameCreator extends MazeGameCreator{

	/**
	 * 
	 */
	public RedMazeGameCreator() {
		// TODO Auto-generated constructor stub
	}

	public static Wall makeWall()
	{
		return new RedWall();
	}
	
	public static Room makeRoom(int n)
	{
		return new RedRoom(n);
	}
	
	/**
	 * Creates a small maze.
	 */
	public static Maze createMaze()
	{
		
		Maze maze = makeMaze();
		Room r0 = makeRoom(0);
		Room r1 = makeRoom(1);
		Door d0 = makeDoor(r0,r1);
		
		r0.setSide(Direction.North, makeWall());
		r0.setSide(Direction.South, makeWall());
		r0.setSide(Direction.East, d0);
		r0.setSide(Direction.West, makeWall());
		
		r1.setSide(Direction.North, makeWall());
		r1.setSide(Direction.South, makeWall());
		r1.setSide(Direction.East, makeWall());
		r1.setSide(Direction.West, d0);
		
		maze.addRoom(r0);
		maze.addRoom(r1);
		maze.setCurrentRoom(0);
		return maze;
	}
	
	/*
	 * Loads a given maze.
	 * @param path : given file path
	 */
	public static Maze loadMaze(final String path) throws FileNotFoundException
	{
		Maze maze = new Maze();
		HashMap<Integer,String[]> roomMap = new HashMap<Integer,String[]>();
		HashMap<Integer,String[]> doorMap = new HashMap<Integer,String[]>();
		ArrayList<Room> roomList = new ArrayList<Room>();
		ArrayList<Door> doorList = new ArrayList<Door>();
		
		// reads user file path
		Scanner in = new Scanner(new FileReader(path));
		int doorCount = 0;
		// parses each line and determines room and door count along with given params
		// adds the room/door and its specific params to a hashmap
		while(in.hasNextLine())
		{
			String line[] = in.nextLine().split(" ");
			if(line[0].equals("room"))
			{
				String sides[] = Arrays.copyOfRange(line, 2, 6);  
				roomMap.put(Integer.parseInt(line[1]), sides);
			}
			else if (line[0].equals("door"))
			{
				String rooms[] = Arrays.copyOfRange(line, 2, 4);  
				doorMap.put(doorCount, rooms);
				doorCount++;
			}
		}
		
		ArrayList<RoomSide> doorSpecList = new ArrayList<RoomSide>(); //list of door specs
		ArrayList<RoomSide> roomSpecList = new ArrayList<RoomSide>(); //list of non-wall room specs
		Direction dir[] = {Direction.North, Direction.South, Direction.East, Direction.West}; //array to hold directions
		// loop through room hashmap
		for(int i : roomMap.keySet())
		{
			//create new room
			Room newRoom = makeRoom(i);
			int dr = 0; //room side direction
			//get the specific room params
			for(String s : roomMap.get(i))
			{
				//if wall create new wall for that side
				if(s.equals("wall"))
				{
					newRoom.setSide(dir[dr], makeWall());
				}
				// if a door, get the door specs and add the door spec listing
				else if(s.contains("d"))
				{
					String doorNum[] = s.split("(?!^)");
					RoomSide roomD = new RoomSide(i,dir[dr], Integer.parseInt(doorNum[1]));
					doorSpecList.add(roomD);
				}
				// if not door or wall, must be another room, get room specs add to room spec listing
				else
				{
					int rm = Integer.parseInt(s);
					RoomSide roomR = new RoomSide(i, dir[dr], rm);
					roomSpecList.add(roomR);
				}
				
				dr++;
			}
			roomList.add(newRoom); //add each room to room list
		}
			
		// loop through doormap and enter rooms that have the door
		for(int i : doorMap.keySet())
		{
			int rm1 = Integer.parseInt(doorMap.get(i)[0]);
			int rm2 = Integer.parseInt(doorMap.get(i)[1]);
			Door newDoor = makeDoor(roomList.get(rm1), roomList.get(rm2));
			doorList.add(newDoor);			
		}
		
		// loop through door specs and add to rooms that contains the door
		for(RoomSide rs : doorSpecList)
		{
			roomList.get(rs.getRoom()).setSide(rs.getSide(), doorList.get(rs.getMapSite()));
		}
		//loop through room specs and add to rooms that have that room as a side
		for(RoomSide rs : roomSpecList)
		{
			roomList.get(rs.getRoom()).setSide(rs.getSide(), roomList.get(rs.getMapSite()));
		}
		
		// add each room to the maze
		for(Room r: roomList)
		{
			maze.addRoom(r);
		}
		// set the first room as the current room
		maze.setCurrentRoom(1);
		
		return maze;
	}
	
}
