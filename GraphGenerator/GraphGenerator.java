package GraphGenerator;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class GraphGenerator {
    public static SortedSet<Edge> Generar(Integer N, Random rand) {
        Integer[][] grid = new Integer[N][4];
        Integer id = 1;
        for (int row = 0; row < N; row++) {
            Integer curr = 0;
            while (curr < 4) {
                Integer blockSize = 1 + rand.nextInt(3);
                for (int col = curr; col < (curr + blockSize) && col < 4; col++) {
                    grid[row][col] = id;
                }
                curr += blockSize;
                if ( curr == 3 && grid[row][2] - grid[row][0] == 2) {
                    grid[row][3] = grid[row][2];
                    curr++;
                }
                id++;
            }
        }

        SortedSet<Edge> edges = new TreeSet<Edge>();
        for (int row = 0; row < N - 1; row++) {
            for (int col = 0; col < 4; col++) {
                Edge edge = new Edge(grid[row][col], grid[row + 1][col]);
                edges.add(edge);
            }
        }
        for (int col = 0; col < 4; col++) {
            Edge edge = new Edge(grid[N - 1][col], id);
            edges.add(edge);
            edge = new Edge(0, grid[0][col]);
            edges.add(edge);
        }

        return edges;
    }

    public static SortedSet<Edge> Generar(Integer N) {
        return GraphGenerator.Generar(N, new Random(42));
    }
}
