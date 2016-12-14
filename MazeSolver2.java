import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 	Given a MazeRoom and a room name, the search facility of this class
 * 	will return a path to the desired room, if one exists.
 * 
 * 	The search will succeed, even if the maze contains cycles (i.e., loops).
 */
public class MazeSolver2
{
	private MazeRoom start;
	
	/**
	 * 	Initializes this object.
	 */
	public MazeSolver2()
	{
		start = MazeRoom.buildCyclicMaze();
	}
	
	/**
	 * 	Provides access to the maze entrance.
	 * 	@return the entrance to the maze.
	 */
	public MazeRoom getEntrance()
	{
		return start;
	}
	
	/**
	 * 	Finds a path from the current room in the maze to the room with the name
	 * 	provided by goal, if one exists.
	 * 	@param current the current room being searched.
	 * 	@param goal the name of the destination room.
	 * 	@param visited all the rooms already searched.
	 * 	@return a path from the current room to the goal (e.g., "A->F->G"), or
	 * 		null if no path exists.
	 */
	public String findPath(MazeRoom current, String goal,
			HashSet<MazeRoom> visited)
	{
		// Your code goes here...
		// Hint: When you enter a room (i.e., current) search each connected,
 		// non-null room (using goNorth(), goSouth(), goEast(), and goWest()),
		// except ones that are already in the set. Stop when the current room's
		// name is the goal.
		visited.add(current);
		String path = current.getName();
		if (current.getName().equals(goal))
		{
		return goal;
		}
		else if( ((current.goNorth() == (null)) || (visited.contains(current.goNorth()))) &&
				 ((current.goEast() == (null)) || (visited.contains(current.goEast()))) &&
				 ((current.goSouth() == (null)) || (visited.contains(current.goSouth()))) &&
				 ((current.goWest() == (null)) || (visited.contains(current.goWest())))	)
		{
			return null;
		}else
		{
			String exit;
			boolean endFound = false; 
			
			if((!(current.goNorth() == (null)) && !(visited.contains(current.goNorth()))) && (endFound == false))
			{
//				System.out.println(current.goNorth().getName());
//				System.out.println(current.goNorth());
				visited.add(current.goNorth());
				exit = findPath(current.goNorth(), goal, visited);	
				if (exit != null)
				{
					path = path + " => " + exit;
					endFound = true;
				}
			}
			
			if ((!(current.goEast() == (null)) && !(visited.contains(current.goEast()))) && (endFound == false))
			{
//				System.out.println(current.goEast().getName());
//				System.out.println(current.goEast());
				visited.add(current.goEast());
				exit = findPath(current.goEast(), goal, visited);
				if (exit != null)
				{
					path = path + " => " + exit;
					endFound = true;
				}
			}
			
			if ((!(current.goSouth() == (null)) && !(visited.contains(current.goSouth()))) && (endFound == false))
			{
//				System.out.println(current.goSouth().getName());
//				System.out.println(current.goSouth());
				visited.add(current.goSouth());
				exit = findPath(current.goSouth(), goal, visited);
				if (exit != null)
				{
					path = path + " => " + exit;
					endFound = true;
				}
			}
			
			if ((!(current.goWest() == (null)) && !(visited.contains(current.goWest()))) && (endFound == false))
			{
//				System.out.println(current.goWest().getName());
//				System.out.println(current.goWest());
				visited.add(current.goWest());
				exit = findPath(current.goWest(), goal, visited);
				if (exit != null)
				{
					path = path + " => " + exit;
					endFound = true;
				}
			}
			
			if (endFound == true)
			{
				return path;
			}else
			{
			 return null;
			}
		}
		
		
	
	}

	/**
	 * 	Used to test the functionality of this class.
	 */
	public static void main(String[] args)
	{
		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);
		MazeSolver2 ms = new MazeSolver2();
		MazeRoom start = ms.getEntrance();
		out.println("The entrance to the maze is room " + start.getName());
		out.print("Enter the destination you want to visit Adrian: ");
		String goal = in.next();
		String path = ms.findPath(start, goal, new HashSet<MazeRoom>());
		out.print("\nThe path from " + start.getName() + " to " + goal + " is ");
		out.println(path == null ? "non existent!" : (path + "."));
	}

}