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

	private class Edge {
		int node;
		int distance;

		public ListItem(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}
	
	public void addEdge(int v1, int v2, int dist) throws GraphException
	{
		if(v1 >= maxNodes || v2 >= maxNodes) 
			throw new GraphException("Invalid node specification");
		if(dist < 0) 
			throw new GraphException("Distance must be >= 0"); 

		Edge edge = new Edge(v2,dist);
		nodeList[v1].add(edge);			//this does not check whether an edge v1-v2 is already
	}							//in the list, so we could get two with different wieghts if 
								//the input is careless
	
	public int dist(int v1, int v2) throws GraphException
	{
		ListIterator i = nodeList[v1].listIterator(0);
		ListItem current;	
		while(i.hasNext())
		{
			current = (Edge) i.next();			//get the next edge in the adjacency-list
			if(c.node == v2) return c.distance;
		}
		throw new GraphException("No such edge");
	}

	public LinkedList getNeighbors(int v)
	{
		return nodeList[v];
	}
}
