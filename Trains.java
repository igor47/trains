
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
	}
}

