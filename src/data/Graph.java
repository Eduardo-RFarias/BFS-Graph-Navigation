package data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.INode;

public class Graph<T extends INode> {
    private final Map<T, List<T>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public Graph(int numVertex) {
        graph = new HashMap<>(numVertex);
    }

    public void addVertex(T vertex) {
        graph.put(vertex, new LinkedList<>());
    }

    public void addEdge(T src, T dest) {
        List<T> srcList = graph.get(src);
        List<T> destList = graph.get(dest);

        if (srcList == null || destList == null) {
            throw new IllegalArgumentException("Vertex does not exist");
        }

        srcList.add(dest);
        destList.add(src);
    }

    public List<T> getNeighbors(T vertex) {
        List<T> neighbors = graph.get(vertex);

        if (neighbors == null) {
            throw new IllegalArgumentException("Vertex does not exist");
        }

        return neighbors;
    }

    public Map<T, List<T>> getGraph() {
        return graph;
    }

    public int getNumVertex() {
        return graph.size();
    }
}
