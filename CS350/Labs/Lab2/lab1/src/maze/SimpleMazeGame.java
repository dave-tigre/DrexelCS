/*
 * SimpleMazeGame.java
 * Copyright (c) 2008, Drexel University.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Drexel University nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY DREXEL UNIVERSITY ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL DREXEL UNIVERSITY BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
 * 
 * @author Sunny
 * @version 1.0
 * @since 1.0
 */
public class SimpleMazeGame
{
	/**
	 * Creates a small maze.
	 */
	public static Maze createMaze()
	{
		
		Maze maze = new Maze();
		Room r0 = new Room(0);
		Room r1 = new Room(1);
		Door d0 = new Door(r0,r1);
		
		r0.setSide(Direction.North, new Wall());
		r0.setSide(Direction.South, new Wall());
		r0.setSide(Direction.East, d0);
		r0.setSide(Direction.West, new Wall());
		
		r1.setSide(Direction.North, new Wall());
		r1.setSide(Direction.South, new Wall());
		r1.setSide(Direction.East, new Wall());
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
			Room newRoom = new Room(i);
			int dr = 0; //room side direction
			//get the specific room params
			for(String s : roomMap.get(i))
			{
				//if wall create new wall for that side
				if(s.equals("wall"))
				{
					newRoom.setSide(dir[dr], new Wall());
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
			Door newDoor = new Door(roomList.get(rm1), roomList.get(rm2));
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

	public static void main(String[] args)
	{
		Maze maze;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter file path of maze (if creating default maze just hit enter) :");
		String path = in.nextLine();
		
		// user enters file path, uses regex in order to determine file location
		// if file path is entered it finds it, else it creates the default
		if(path.contains("\\"))
		{
			path = path.replace("\\", "/");
			try {
				maze = loadMaze(path);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found, creating default maze...");
				maze = createMaze();
			}
		}
		else
		{
			maze = createMaze();
		}
		
	    MazeViewer viewer = new MazeViewer(maze);
	    viewer.run();
	}
}

/*
 * RoomSide
 * 
 * Structure made to hold information about room sides that are not walls.
 */
class RoomSide {
	private int room;
	private Direction side;
	private int mapsite;
	public RoomSide(int room, Direction side, int mapsite)
	{
		this.room = room;
		this.side = side;
		this.mapsite = mapsite;
	}
	
	public int getRoom() {return room;}
	public Direction getSide() {return side;}
	public int getMapSite() {return mapsite;}
}
