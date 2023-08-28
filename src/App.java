import data.BFS;
import data.Graph;
import model.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Graph<Person> graph = new Graph<>(7);

        Person p1 = new Person(1, "1");
        Person p2 = new Person(2, "2");
        Person p3 = new Person(3, "3");
        Person p4 = new Person(4, "4");
        Person p5 = new Person(5, "5");
        Person p6 = new Person(6, "6");
        Person p7 = new Person(7, "7");

        graph.addVertex(p1);
        graph.addVertex(p2);
        graph.addVertex(p3);
        graph.addVertex(p4);
        graph.addVertex(p5);
        graph.addVertex(p6);
        graph.addVertex(p7);

        graph.addEdge(p1, p2);
        graph.addEdge(p1, p4);
        graph.addEdge(p1, p5);
        graph.addEdge(p2, p6);
        graph.addEdge(p3, p7);
        graph.addEdge(p4, p5);
        graph.addEdge(p4, p2);

        BFS.search(graph);
    }
}
