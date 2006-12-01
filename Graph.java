import java.util.*;

public class Graph extends AdjacencyList{
	public Graph() { super(); }

	private class Status {
		int node;
		int distance;
		boolean done;

		public Status(int dist, boolean d) {	//used in finding smallest route
			distance = dist; done = d;
		}

		public Status(int n, int dist) {  //used in finding all routes
			node = n; distance = dist;
		}
	}
	
	/*note: this function, which returns the index of the element
	 * with the smallest distance, could be greatly optimized through use of
	 * a priority queue instead of a simple array */
	private int getClosest(Status [] status)
	{
		int i, smallest=0;
		int smallestIndex = -1;			//the default return value
		for(i=0; i<maxNodes; i++)
		{
			if(status[i] == null) continue;	//unitialized status
			if(status[i].done == false) {	//found a candidate
				//if its the first candidate, or smaller then prev candidate
				if(smallestIndex == -1 || status[i].distance < smallest) {
					smallest = status[i].distance;
					smallestIndex = i;
				}
			}
		}
		return smallestIndex;
	}
	
	public int shortestPath(int start, int end) throws GraphException
	{
		Status [] status = new Status [maxNodes];
		status[start] = new Status(0,false);
		int current = start;

		while( current != end) //while the current is not the one we're looking for
		{
			LinkedList neighborList = getNeighbors(current);	//get neighbors
			ListIterator i = neighborList.listIterator(0);
			while(i.hasNext())									//for each neighbor
			{
				Edge neighbor = (Edge) i.next();
				int distanceThroughCurrent = status[current].distance + neighbor.distance;
				if(status[neighbor.node] == null) 				//if we've never seen it before
				{												//so add it to status list
					status[neighbor.node] = new Status(distanceThroughCurrent,false);
					System.out.println("From " + current + "found " + neighbor.node + 
							" with distance " + distanceThroughCurrent);
				}

																//if we've found a shorter path
				else if(status[neighbor.node].distance > distanceThroughCurrent)
					status[neighbor.node].distance = distanceThroughCurrent; //change distance
			}  //done going through neighbors

			status[current].done = true;	//we should never come back to the current node
			current = getClosest(status);	//the next node is the closest onea
			if(current==-1) throw new GraphException("No such path");  //if no more next nodes
		} while(true)
		
		return status[end].distance;
	}
				
	public int [] allRoutesDistances(int start, int end, int maxDistance) throws GraphException
	{
		LinkedList queue = new LinkedList();
		LinkedList distances = new LinkedList();
		
		queue.add( new Status(start, 0) );		//add start node to queue
		
		while( !queue.isEmpty()) {							//while we have paths to explore
			Status current = (Status) queue.removeFirst();
			if(current.node == end) 			//found another path to end
				distances.add(new Integer(current.distance));	//take down its distance

			LinkedList neighborList = getNeighbors(current.node);	//get neighbor list
			ListIterator i = neighborList.listIterator(0);
			while(i.hasNext())
			{
				Edge neighbor = (Edge) i.next();					//for each neighbor
				
				int distanceFromStart = current.distance + neighbor.distance;
				if( distanceFromStart < maxDistance)
					queue.add( new Status( neighbor.node, distanceFromStart) );
			}
		}									//done finding distances

		int [] dists = new int[distances.size()];		//create return list
		int i;
		for( i = 0; !distances.isEmpty(); i++)
			dists[i] = ((Integer)distances.removeFirst()).intValue();
		return dists;
	}

	public int [] allRoutesHops(int start, int end, int maxHops)
	{
		return new int [0];
	}
}
