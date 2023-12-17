package GraphPackage;

/*
 * Vertex class for vertex of graph
 * Initializes vertex
 * returns vertex label, and vertices&hashcodes based on vertex label
 */

public class Vertex<T> {

    private T label;

    public Vertex(T label) {
        this.label = label;
    }

    public T getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) obj;
        return label.equals(vertex.label);
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public String toString() {
        return label.toString();
    }
}
