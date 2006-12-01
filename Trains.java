
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
			AdjacencyList al = new AdjacencyList();
			al.addEdge(3,2,5);
			System.out.println("Distance between 3 and 2 is " + al.dist(3,2));
			int a, b;
			a = al.dist(3,5);
			b = al.dist(1,2);
		} catch(GraphException e) {
			System.out.println("Graph Exception:");
			System.out.println(e.getError());
		}
	}
}

