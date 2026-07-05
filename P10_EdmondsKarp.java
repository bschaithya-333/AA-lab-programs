// 13. Connected Components using BFS
import java.util.*;
public class P13_ConnectedComponentsBFS {
    static void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");
            for (int adj : graph.get(v)) if (!visited[adj]) { visited[adj] = true; q.add(adj); }
        }
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
                bfs(i, graph, visited);
                System.out.println();
            }
        }
        System.out.println("Total Components = " + count);
    }
}
