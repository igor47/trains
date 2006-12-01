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

	private int [] listToArray(LinkedList list)
	{
		int [] array = new int[list.size()];		//create return list
		int i;
		for( i = 0; !list.isEmpty(); i++)
			array[i] = ((Integer)list.removeFirst()).intValue();
		return array;
	}


				
	public int [] allPathsDistance(int start, int end, int maxDistance) throws GraphException
	{
		LinkedList queue = new LinkedList();
		LinkedList distances = new LinkedList();
		
		Status current = new Status(start, 0);		//initialize current
		
		for(;;){
			LinkedList neighborList = getNeighbors(current.node);	//get neighbor list
			ListIterator i = neighborList.listIterator(0);
			while(i.hasNext())
			{
				Edge neighbor = (Edge) i.next();					//for each neighbor
				
				int distanceFromStart = current.distance + neighbor.distance;
				if( distanceFromStart < maxDistance)				//add to queue if within range
					queue.add( new Status( neighbor.node, distanceFromStart) );
			}
		
			try { current = (Status) queue.removeFirst();	//try to get next node to explore
			} catch (NoSuchElementException e) {break;}			//break if none
			
			if(current.node == end )			 		//if we found another path to end
				distances.add(new Integer(current.distance));	//take down its distance
		}

		return listToArray(distances);
	}

	public int [] allPathsHops(int start, int end, int maxHops)
	{
		LinkedList queue = new LinkedList();
		LinkedList distances = new LinkedList();
		
		Status current = new Status(start, 0);		//initialize current
		
		for(;;){
			LinkedList neighborList = getNeighbors(current.node);	//get neighbor list
			ListIterator i = neighborList.listIterator(0);
			while(i.hasNext())
			{
				Edge neighbor = (Edge) i.next();					//for each neighbor
				
				int hopsFromStart = current.distance + 1;
				if( hopsFromStart < maxHops)				//add to queue if within range
					queue.add( new Status( neighbor.node, hopsFromStart) );
			}
		
			try { current = (Status) queue.removeFirst();	//try to get next node to explore
			} catch (NoSuchElementException e) {break;}			//break if none
			
			if(current.node == end )			 		//if we found another path to end
				distances.add(new Integer(current.distance));	//take down its distance
		}

		return listToArray(distances);
	}
}
