package GraphPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedGraph<T> implements GraphInterface<T> {

    private Map<Vertex<T>, List<Vertex<T>>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    @Override
    public boolean addVertex(T vertexLabel) {
        Vertex<T> newVertex = new Vertex<>(vertexLabel);
        adjacencyList.putIfAbsent(newVertex, new ArrayList<>());
        return true;
    }

    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        Vertex<T> vertex1 = getVertex(begin);
        Vertex<T> vertex2 = getVertex(end);

        if (vertex1 != null && vertex2 != null) {
            adjacencyList.get(vertex1).add(vertex2);
            adjacencyList.get(vertex2).add(vertex1);
            return true;
        }

        return false;
    }

    @Override
    public boolean hasVertex(T vertexLabel) {
        return getVertex(vertexLabel) != null;
    }

    @Override
    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }

    @Override
    public int getNumberOfVertices() {
        return adjacencyList.size();
    }

    @Override
    public int getNumberOfEdges() {
        int edgeCount = 0;
        for (List<Vertex<T>> edges : adjacencyList.values()) {
            edgeCount += edges.size();
        }
        return edgeCount / 2;
    }

    @Override
    public void clear() {
        adjacencyList.clear();
    }

    @Override
    public void display() {
        for (Vertex<T> vertex : adjacencyList.keySet()) {
            System.out.print(vertex + ": ");
            List<Vertex<T>> neighbors = adjacencyList.get(vertex);
            for (Vertex<T> neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    @Override
    public List<T> getDepthFirstTraversal(T origin) {
        return new ArrayList<>();
    }

    @Override
    public List<T> getBreadthFirstTraversal(T origin) {
        return new ArrayList<>();
    }

    @Override
    public List<T> getShortestPath(T begin, T end) {
        return new ArrayList<>();
    }

    @Override
    public double getShortestPathLength(T begin, T end) {
        return 0.0;
    }

    @Override
    public boolean removeVertex(T vertexLabel) {
        Vertex<T> vertexToRemove = getVertex(vertexLabel);
        if (vertexToRemove != null) {
            adjacencyList.remove(vertexToRemove);
            for (List<Vertex<T>> edges : adjacencyList.values()) {
                edges.remove(vertexToRemove);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEdge(T begin, T end) {
        Vertex<T> vertex1 = getVertex(begin);
        Vertex<T> vertex2 = getVertex(end);

        if (vertex1 != null && vertex2 != null) {
            adjacencyList.get(vertex1).remove(vertex2);
            adjacencyList.get(vertex2).remove(vertex1);
            return true;
        }

        return false;
    }

    @Override
    public List<Vertex<T>> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    @Override
    public List<Vertex<T>> getNeighbors(Vertex<T> vertex) {
        return new ArrayList<>(adjacencyList.get(vertex));
    }

    public Vertex<T> getVertex(T vertexLabel) {
        for (Vertex<T> vertex : adjacencyList.keySet()) {
            if (vertex.getLabel().equals(vertexLabel)) {
                return vertex;
            }
        }
        return null;
    }
}
