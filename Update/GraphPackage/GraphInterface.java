package GraphPackage;

import java.util.List;

/*
 * GraphInterface defines methods for UndirectedGraph class
 * adds vertex & edges
 * returns # of vertices, # of edges,depth/breadth first traversals, and neighbors
 * removes vertex, edges, and vertices
 */

public interface GraphInterface<T> {

    boolean addVertex(T vertexLabel);

    boolean addEdge(T begin, T end, double edgeWeight);

    boolean hasVertex(T vertexLabel);

    boolean isEmpty();

    int getNumberOfVertices();

    int getNumberOfEdges();

    void clear();

    void display();

    List<T> getDepthFirstTraversal(T origin);

    List<T> getBreadthFirstTraversal(T origin);

    List<T> getShortestPath(T begin, T end);

    double getShortestPathLength(T begin, T end);

    boolean removeVertex(T vertexLabel);

    boolean removeEdge(T begin, T end);

    List<Vertex<T>> getVertices();

    List<Vertex<T>> getNeighbors(Vertex<T> vertex);
}
