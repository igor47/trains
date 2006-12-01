import java.util.*;

public interface GraphRepresentation {
    public void addEdge(int v1, int v2, int dist) throws GraphException;
    public int distance(int v1, int v2) throws GraphException;
	public LinkedList getNeighbors(int v) throws GraphException;
}
