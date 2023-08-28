package data;

import java.util.HashMap;
import java.util.LinkedList;

import model.INode;

public class Graph<T extends INode> {
    private final HashMap<Integer, LinkedList<T>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public Graph(int numVertex) {
        graph = new HashMap<>(numVertex);
    }

    public void addVertex(T vertex) {
        graph.put(vertex.getId(), new LinkedList<>());
    }

    public void addEdge(T src, T dest) {
        LinkedList<T> srcList = graph.get(src.getId());
        LinkedList<T> destList = graph.get(dest.getId());

        if (srcList == null || destList == null) {
            throw new IllegalArgumentException("Vertex does not exist");
        }

        srcList.add(dest);
        destList.add(src);
    }

    public int getNumVertex() {
        return graph.size();
    }

    public LinkedList<T> getNeighbors(T vertex) {
        LinkedList<T> neighbors = graph.get(vertex.getId());

        if (neighbors == null) {
            throw new IllegalArgumentException("Vertex does not exist");
        }

        return neighbors;
    }

    public LinkedList<T> getNeighbors(int vertexId) {
        LinkedList<T> neighbors = graph.get(vertexId);

        if (neighbors == null) {
            throw new IllegalArgumentException("Vertex does not exist");
        }

        return neighbors;
    }

    public HashMap<Integer, LinkedList<T>> getGraph() {
        return graph;
    }
}
