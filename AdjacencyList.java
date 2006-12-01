import java.util.*;

/* An adjacency list is one way of representing a graph (another is adjacency 
 * matrix).  Here, the Adjacency list is implemented as an array of LinkedLists.
 * nodeList[v] contains the LinkedList of edges outgoing from v. The edges are 
 * stored as Edge objects, containing the neighbor of v and its distance.
 */
public class AdjacencyList implements GraphRepresentation {
	public AdjacencyList(){ 
		this.nodeList = new LinkedList[maxNodes];
	}
	//we assume that since only capital letters can be used as nodes,
	final int maxNodes = 27;		//there will not be more than 27 nodes.
	LinkedList [] nodeList;

	public class Edge {
		int node;
		int distance;

		public Edge(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

	private void checkValid(int v) throws GraphException {
		if(v < 0 || v >= maxNodes)
			throw new GraphException("Invalid node");
	}

	public void addEdge(int v1, int v2, int dist) throws GraphException
	{
		checkValid(v1); checkValid(v2);
		if(dist < 0) 
			throw new GraphException("Distance must be >= 0"); 

		if(nodeList[v1] == null) nodeList[v1] = new LinkedList();
		
		Edge edge = new Edge(v2,dist);
		nodeList[v1].add(edge);			//this does not check whether an edge v1-v2 is already
	}							//in the list, so we could get two with different wieghts if 
								//the input is careless
	
	public int distance(int v1, int v2) throws GraphException
	{
		checkValid(v1); checkValid(v2);
		ListIterator i = nodeList[v1].listIterator(0);
		while(i.hasNext())
		{
			Edge current = (Edge) i.next();			//get the next edge in the adjacency-list
			if(current.node == v2) return current.distance;
		}
		throw new GraphException("No such edge");
	}

	public LinkedList getNeighbors(int v) throws GraphException
	{
		checkValid(v);
		if(nodeList[v] == null) nodeList[v] = new LinkedList();
		return nodeList[v];
	}
}
