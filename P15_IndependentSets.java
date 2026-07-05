// 14. Connected Components using DFS
import java.util.*;
public class P14_ConnectedComponentsDFS {
    static void dfs(int v, List<List<Integer>> graph, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int adj : graph.get(v)) if (!visited[adj]) dfs(adj, graph, visited);
    }

    public static void main(String[] args) {
        int V = 7;
        int[][] edges = {{0,1},{1,2},{3,4},{5,6}};
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) { graph.get(e[0]).add(e[1]); graph.get(e[1]).add(e[0]); }

        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                System.out.print("Component " + count + ": ");
                dfs(i, graph, visited);
                System.out.println();
            }
        }
        System.out.println("Total Components = " + count);
    }
}
