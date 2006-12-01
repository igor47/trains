import java.io.*;

public class TrainMap extends Graph{
    public TrainMap(String filename) {
		super();
        createMap(filename);
    }

    private String readGraphData(String filename) throws IOException,FileNotFoundException
    {
        BufferedReader dataFile = new BufferedReader( new FileReader(filename) );
        String line, data;
        data = "";

        while ( (line = dataFile.readLine()) != null )
            data += line;

        return data;
    }

	private int tr(char v) {
		return Character.getNumericValue(v) - 10;
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

		String [] edges = data.split("[\\s]*,[\\s]*");
		int i;
		for(i = 0; i < edges.length; i++){
			int weight = Integer.parseInt(edges[i].substring(2));
			try{
				addEdge(tr(edges[i].charAt(0)),tr(edges[i].charAt(1)),weight);
			} catch(GraphException e) { System.out.println(e.errorMsg()); }
		}
    }

    //answers questions 1-5
    public Object routeDistance(String route) 
	{
		int i, rd = 0;

		try{
			for(i=0; i < (route.length() - 1); ) {
				rd += distance(tr(route.charAt(i)),tr(route.charAt(++i)));
			}
		} catch (GraphException e) {
			return "No such route"; 
		}
				
        return new Integer(rd);
    }


    //answers questions 8,9
    public Object shortestPathDist(char start, char end){
		try {
			return new Integer(shortestPath(tr(start),tr(end)));
		} catch (GraphException e) { return e.errorMsg(); }
    }

    //answers question 10
    public Object numberOfPaths_Distance(char start, char end, int maxDist)
    {
		try {
			return new Integer(allPathsDistance(tr(start),tr(end),maxDist).length);
		} catch (GraphException e) { return e.errorMsg(); }
    }

    //answers question 6
    public Object numberOfPaths_MaxHops(char start, char end, int maxHops)
    {
		try {
			return new Integer(allPathsHops(tr(start),tr(end),maxHops).length);
		} catch (GraphException e) { return e.errorMsg(); }
    }

    //answers question 7
    public Object numberOfPaths_ExactHops(char start, char end, int hops)
    {
		int [] pathLengths;
		try {
			pathLengths = allPathsHops(tr(start),tr(end),hops);
		} catch(GraphException e) { return e.errorMsg(); }

		int i, paths=0;				//count paths that are exactly hops long
		for(i=0; i < pathLengths.length; i++)
			if(pathLengths[i] == hops) 
				paths+=1;
		
        return new Integer(paths);
    }
}
