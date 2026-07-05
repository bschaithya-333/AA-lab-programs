// 15. All Independent Sets Generation
import java.util.*;
public class P15_IndependentSets {
    static boolean[][] graph;
    static int V;

    static boolean isIndependent(List<Integer> set, int vertex) {
        for (int v : set) if (graph[v][vertex]) return false;
        return true;
    }

    static void findSets(int vertex, List<Integer> current) {
        if (vertex == V) { System.out.println(current); return; }
        if (isIndependent(current, vertex)) {
            current.add(vertex);
            findSets(vertex + 1, current);
            current.remove(current.size() - 1);
        }
        findSets(vertex + 1, current);
    }

    public static void main(String[] args) {
        V = 4;
        int[][] edges = {{0,1},{0,3},{1,2},{2,3}};
        graph = new boolean[V][V];
        for (int[] e : edges) { graph[e[0]][e[1]] = true; graph[e[1]][e[0]] = true; }
        System.out.println("All Independent Sets:");
        findSets(0, new ArrayList<>());
    }
}
