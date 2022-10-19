import GraphGenerator.*;

import java.util.SortedSet;

public class JavaQuest {
    public static void main(String[] args) {
        SortedSet<Edge> edges = GraphGenerator.Generar(5, 50);
        int i = 0;
        for (Edge e : edges) {
            System.out.printf("%d: (%d, %d)\n", i++, e.x, e.y);
        }
    }
}
