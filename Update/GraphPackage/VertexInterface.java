package GraphPackage;

import java.util.List;

/*
 * VertexInterface defines methods for Vertex class
 * returns vertex labels, neighbors, neighbors weight, neighbors count
 * disconnects vertex from a specific vertex, or all vertex
 * sets labels, vertex as visited/not visited, connects vertex
 */

public interface VertexInterface<T> {

    T getLabel();
    void setLabel(T label);
    void visit();
    void unvisit();
    boolean isVisited();
    boolean connect(VertexInterface<T> endVertex, double edgeWeight);
    boolean disconnect(VertexInterface<T> endVertex);
    double getWeight(VertexInterface<T> endVertex);
    List<VertexInterface<T>> getNeighbors();
    List<Double> getNeighborWeights();
    int getNeighborCount();
    void disconnectAll();
}
