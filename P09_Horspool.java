// 22. Kruskal's Algorithm (Minimum Spanning Tree)
import java.util.*;
public class P22_Kruskal {
    static int[] parent;
    static int find(int i) { return parent[i] == i ? i : (parent[i] = find(parent[i])); }
    static void union(int x, int y) { parent[find(x)] = find(y); }

    record Edge(int src, int dest, int weight) {}

    public static void main(String[] args) {
        int V = 5;
        Edge[] edges = {
            new Edge(0,1,3), new Edge(0,4,10), new Edge(0,3,5),
            new Edge(1,2,8), new Edge(1,3,9), new Edge(2,3,1)
        };
        Arrays.sort(edges, Comparator.comparingInt(Edge::weight));
        parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int cost = 0;
        System.out.println("Edges in MST: ");
        for (Edge e : edges) {
            int x = find(e.src()), y = find(e.dest());
            if (x != y) {
                System.out.println(e.src() + " - " + e.dest() + " : " + e.weight());
                cost += e.weight();
                union(x, y);
            }
        }
        System.out.println("Minimum cost = " + cost);
    }
}
