
import java.io.*;
	
public class Trains {
	public static void main(String args[])
	{
		String filename;
		try { 
			filename = args[0]; 
		} catch(ArrayIndexOutOfBoundsException e)	{
			System.out.println("Usage: java Trains <filename>");
			return;
		}
		
	//	TrainMap trainMap = new TrainMap(filename);
		try {
			Graph al = new Graph();
			al.addEdge(1,2,5);
			al.addEdge(2,3,4);
			al.addEdge(3,4,8);
			al.addEdge(4,3,8);
			al.addEdge(4,5,6);
			al.addEdge(1,4,5);
			al.addEdge(3,5,2);
			al.addEdge(5,2,3);
			al.addEdge(1,5,7);
			System.out.println("Distance between A and E is " + al.distance(1,5));
			System.out.println("Shorest distance between A and C is " + al.shortestPath(1,3));
			System.out.println("Shorest distance between B and E is " + al.shortestPath(2,5));
			System.out.println("Number of rouetes between C and C < 30 is " + (al.allPathsDistance(3,3,30)).length);
			System.out.println(al.allPathsDistance(3,3,30)[0]);
		} catch(GraphException e) {
			System.out.println("Graph Exception:");
			System.out.println(e.getError());
		}
	}
}

