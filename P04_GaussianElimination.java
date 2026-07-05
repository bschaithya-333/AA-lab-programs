// 10. Max-Flow Problem using Edmonds-Karp Algorithm
import java.util.*;
public class P10_EdmondsKarp {
    static boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        int n = rGraph.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(s); visited[s] = true; parent[s] = -1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < n; v++)
                if (!visited[v] && rGraph[u][v] > 0) { q.add(v); parent[v] = u; visited[v] = true; }
        }
        return visited[t];
    }

    static int maxFlow(int[][] graph, int s, int t) {
        int n = graph.length;
        int[][] rGraph = new int[n][n];
        for (int i = 0; i < n; i++) rGraph[i] = graph[i].clone();
        int[] parent = new int[n];
        int flow = 0;
        while (bfs(rGraph, s, t, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) pathFlow = Math.min(pathFlow, rGraph[parent[v]][v]);
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }
            flow += pathFlow;
        }
        return flow;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0,7,10,0,0,0,0},
            {0,0,1,3,5,0,0},
            {0,0,0,2,0,7,0},
            {0,0,0,0,0,3,2},
            {0,0,0,0,0,2,10},
            {0,0,0,0,0,0,4},
            {0,0,0,0,0,0,0}
        };
        System.out.println("Maximum flow = " + maxFlow(graph, 0, 6));
    }
}
