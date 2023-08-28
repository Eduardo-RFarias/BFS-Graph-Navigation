package data;

import java.util.ArrayList;

import model.INode;
import model.Path;

public class BFS {
    private static ArrayList<Integer> accessed;
    private static ArrayList<Integer> notAccessed;
    private static ArrayList<Path> pathsUsed;
    private static ArrayList<Integer> queue;

    private static void clear() {
        accessed = null;
        notAccessed = null;
        pathsUsed = null;
        queue = null;
    }

    private static <T extends INode> void init(Graph<T> graph) {
        int numVertex = graph.getNumVertex();

        accessed = new ArrayList<>(numVertex);
        notAccessed = new ArrayList<>(numVertex);
        pathsUsed = new ArrayList<>(numVertex * 2);
        queue = new ArrayList<>(numVertex);

        for (int vertex : graph.getGraph().keySet()) {
            notAccessed.add(vertex);
        }
    }

    public static <T extends INode> void search(Graph<T> graph) {
        clear();
        init(graph);

        while (!notAccessed.isEmpty()) {
            int vertex = notAccessed.get(0);
            queue.add(vertex);
            accessed.add(vertex);
            notAccessed.remove(0);

            while (!queue.isEmpty()) {
                int currentVertex = queue.get(0);
                queue.remove(0);

                for (T neighbor : graph.getNeighbors(currentVertex)) {
                    if (!accessed.contains(neighbor.getId())) {
                        pathsUsed.add(new Path(currentVertex, neighbor.getId()));
                        accessed.add(neighbor.getId());
                        notAccessed.remove(notAccessed.indexOf(neighbor.getId()));
                        queue.add(neighbor.getId());
                    }
                }
            }
        }

        System.out.println("Paths used:");
        for (Path path : pathsUsed) {
            System.out.println(path);
        }

        System.out.println("\nAccessed vertexes:");
        for (int vertex : accessed) {
            System.out.println(vertex);
        }
    }
}
