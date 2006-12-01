
public interface GraphRepresentation {
    public void addEdge(v1,v2,dist);
    public int dist(v1,v2);
    public boolean isNode(v);
    public boolean hasEdge(v1,v2);
}

public class GraphException extends Exception {
	String errorMsg;
	public GraphException()	{
		this.errorMsg = "Not set";
	}

	public GraphException(String msg){
		this.errorMsg = msg;
	}

	public getError() {
		return this.errorMsg;
	}
}

public class AdjacencyMatrix implements GraphRepresentation {
	public AdjacencyMatrix() 		//the constructor initializes an empty matrix & nodelist
	{
		int [][] matrix = new int [matrixSize][matrixSize];
		int i, j;

		for(i=0; i < matrixSize; i++)
			for(j=0; j < matrixSize; j++)
				matrix[i][j] = -1;			//we assume a negative number cannot be a distance

		boolean [] nodeList = new boolean [matrixSize];	//initialize a list of existant nodes
		for(i = 0; i < matrixSize; i++)
			nodeList[i] = false;

		this.nodeExists = nodeList;
		this.matrix = matrix;
	}

	boolean [] nodeExists;
	int [][] matrix;
	final int matrixSize = 27;	//we assume that since only capital letters can be used as nodes, 
							//there will not be more than 27 nodes.  If this changes, a re-
							//initializer function can be created which doubles the size of the
							//matrix and copies the older matrix.  doubling the size will cause
							//matrixSize to converge to an adequately large number exponentially fast
							//this re-initializer function is not provided since it is not deemed needed,
							//and the current implementation will throw an exception if it runs out of room
	
	public void addEdge(v1,v2,dist)
	{
		nodeExists[v1]=true;
		nodeExists[v2]=true;

		if(dist < 0) throw 
		matrix[v1][v2] = dist;
		

public class Route {
	public Route(String route, int distance)
	{
		this.route = route;
		this.distance = distance;
	}
	
	String route;
	int distance;
}
	

public class Graph {
	public int distance(v1,v2)
	{
		return 0;
	}
	
	public Route shortestPath(start,end)
	{
		return;
	}

	public Route[] allRoutesDistances(start,end,maxDistance)
	{
		return;
	}

	public Route[] allRoutesHops(start,end,maxHops)
	{
		return;
	}
}
