import java.io.*;

public class TrainMap {
    public TrainMap(String filename)
    {
        map = 0;
        createMap(filename);
    }

    int map;

    private String readGraphData(String filename) throws IOException,FileNotFoundException
    {
        BufferedReader dataFile = new BufferedReader( new FileReader(filename) );
        String line, data;
        data = "";

        while ( (line = dataFile.readLine()) != null )
            data += line;

        return data;
    }

    public void createMap(String filename)
    {
		String data;
		try {
	        data = readGraphData(filename);
		} catch(Exception e) {
			System.out.println("Could not read graph data");
			System.out.println(e.toString());
			return;
		}
	
        System.out.println("Read " + data);
    }

    //answers questions 1-5
    public int routeDistance(String route) throws NoSuchRouteException{
        return 0;
    }


    //answers questions 8,9
    public int shortestPathDist(char start, char end) throws NoSuchRouteException{
        return 0;
    }

    //answers question 10
    public int numberOfPaths_Distance(char start, char end)
    {
        return 0;
    }

    //answers question 6
    public int numberOfPaths_MaxHops(char start, char end, int maxHops)
    {
        return 0;
    }

    //answers question 7
    public int numberOfPaths_ExactHops(char start, char end, int hops)
    {
        return 0;
    }

    public class NoSuchRouteException extends Exception {
        public NoSuchRouteException(){}
    }
}
