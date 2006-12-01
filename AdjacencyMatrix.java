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
	/*we assume that since only capital letters can be used as nodes, there will 
	 * not be more than 27 nodes.  If this changes, a reinitializer function can 
	 * be created which doubles the size of the matrix and copies the older matrix.
	 * doubling the size will cause matrixSize to converge to an adequately large 
	 * number exponentially fast this re-initializer function is not provided since 
	 * it is not deemed needed, and the current implementation will throw an exception 
	 * if it runs out of room */
	final int matrixSize = 27;
	
	public void addEdge(int v1, int v2, int dist) throws GraphException
	{
		if(v1 >= matrixSize || v2 >= matrixSize) 
			throw new GraphException("");
		if(dist < 0) 
			throw new GraphException("Distance must be >= 0"); 
		
		nodeExists[v1]=true;
		nodeExists[v2]=true;
		matrix[v1][v2] = dist;
	}

	public int dist(int v1, int v2) throws GraphException
	{
		if(!nodeExists[v1] || !nodeExists[v2] ) 
			throw new GraphException("Node does not exist");

		int distance;
		if( (distance = matrix[v1][v2]) == -1 )
			throw new GraphException("No such edge");

		return distance;
	}
}
