
public interface GraphRepresentation {
    public void addEdge(int v1, int v2, int dist) throws GraphException;
    public int dist(int v1, int v2) throws GraphException;
}
