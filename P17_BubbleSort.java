// 27. Min-Cut Theorem on Flow Networks
import java.util.*;
public class P27_MinCut {
    static int V;

    static boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s); visited[s] = true; parent[s] = -1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < V; v++)
                if (!visited[v] && rGraph[u][v] > 0) { q.add(v); parent[v] = u; visited[v] = true; }
        }
        return visited[t];
    }

    static void dfs(int[][] rGraph, int s, boolean[] visited) {
        visited[s] = true;
        for (int i = 0; i < V; i++) if (rGraph[s][i] > 0 && !visited[i]) dfs(rGraph, i, visited);
    }

    static void minCut(int[][] graph, int s, int t) {
        int[][] rGraph = new int[V][V];
        for (int i = 0; i < V; i++) rGraph[i] = graph[i].clone();
        int[] parent = new int[V];
        while (bfs(rGraph, s, t, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) pathFlow = Math.min(pathFlow, rGraph[parent[v]][v]);
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }
        }
        boolean[] visited = new boolean[V];
        dfs(rGraph, s, visited);

        int minCutValue = 0;
        System.out.println("MinCut Edges: ");
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                if (visited[i] && !visited[j] && graph[i][j] > 0) {
                    System.out.println(i + " - " + j);
                    minCutValue += graph[i][j];
                }
        System.out.println("Min cut value = " + minCutValue);
    }

    public static void main(String[] args) {
        V = 7;
        int[][] graph = {
            {0,7,10,0,0,0,0},
            {0,0,1,3,5,0,0},
            {0,0,0,2,0,7,0},
            {0,0,0,0,0,3,2},
            {0,0,0,0,0,2,10},
            {0,0,0,0,0,0,4},
            {0,0,0,0,0,0,0}
        };
        minCut(graph, 0, 6);
    }
}
