
public interface GraphRepresentation {
    public void addEdge(v1,v2,dist);
    public int dist(v1,v2);
    public boolean isNode(v);
    public boolean hasEdge(v1,v2);
}

//public class AdjacencyList implements GraphRepresentation {

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
