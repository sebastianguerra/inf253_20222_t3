import GraphGenerator.*;

import java.util.SortedSet;

public class JavaQuest {
    public static void main(String[] args) {
        SortedSet<Edge> edges = GraphGenerator.Generar(5);
        int i = 0;
        for (Edge e : edges) {
            System.out.printf("(%d) -> (%d)\n", e.x, e.y);
        }
    }
}
