package data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Map.Entry;

import model.INode;
import model.Path;

public class BFS {
    public static <T extends INode> List<Path<T>> search(Graph<T> graph) {
        int numVertex = graph.getNumVertex();

        List<T> notAccessed = new ArrayList<>(numVertex);
        List<Path<T>> pathsUsed = new ArrayList<>(numVertex * 2);
        Queue<T> queue = new ArrayDeque<>(numVertex);

        // Add all vertexes to the list of not accessed vertexes
        for (Entry<T, List<T>> vertex : graph.getGraph().entrySet()) {
            notAccessed.add(vertex.getKey());
        }

        // While there are vertexes which were not accessed yet
        while (!notAccessed.isEmpty()) {
            // Get the first vertex which was not accessed yet
            T vertex = notAccessed.get(0);

            // Add the vertex to the queue and mark it as accessed by
            // removing it from the list of not accessed vertexes
            queue.add(vertex);
            notAccessed.remove(0);

            // While there are vertexes in the queue
            while (!queue.isEmpty()) {
                // Get the first vertex in the queue
                T currentVertex = queue.remove();

                // For each neighbor of the current vertex
                for (T neighbor : graph.getNeighbors(currentVertex)) {
                    // If the neighbor was not accessed yet
                    if (notAccessed.contains(neighbor)) {
                        // Create a path from the current vertex to the neighbor
                        Path<T> path = new Path<>(currentVertex, neighbor);

                        // Add the path to the list of paths used
                        pathsUsed.add(path);

                        // Mark the neighbor as accessed by removing
                        // it from the list of not accessed vertexes
                        notAccessed.remove(notAccessed.indexOf(neighbor));

                        // Add the neighbor to the queue
                        queue.add(neighbor);
                    }
                }
            }
        }

        return pathsUsed;
    }
}
