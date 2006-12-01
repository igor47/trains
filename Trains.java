
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
		
		TrainMap trainMap = new TrainMap(filename);

		System.out.println("Output #1: " + trainMap.routeDistance("ABC")); 
		System.out.println("Output #2: " + trainMap.routeDistance("AD")); 
		System.out.println("Output #3: " + trainMap.routeDistance("ADC")); 
		System.out.println("Output #4: " + trainMap.routeDistance("AEBCD")); 
		System.out.println("Output #5: " + trainMap.routeDistance("AED")); 

		System.out.println("Output #6: " + trainMap.numberOfPaths_MaxHops('C','C',3));
		System.out.println("Output #7: " + trainMap.numberOfPaths_ExactHops('A','C',4));
		System.out.println("Output #8: " + trainMap.shortestPathDist('A','C'));
		System.out.println("Output #9: " + trainMap.shortestPathDist('B','B'));
		System.out.println("Output #10: " + trainMap.numberOfPaths_Distance('C','C',29));
	}
}
