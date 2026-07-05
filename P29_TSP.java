// 26. Dijkstra's Shortest Path Algorithm
public class P26_Dijkstra {
    public static void main(String[] args) {
        int[][] graph = {
            {0,3,0,5,10},
            {3,0,8,7,0},
            {0,8,0,1,8},
            {5,7,1,0,2},
            {10,0,8,2,0}
        };
        int n = graph.length, src = 0;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        java.util.Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = -1;
            for (int i = 0; i < n; i++) if (!visited[i] && (u == -1 || dist[i] < dist[u])) u = i;
            visited[u] = true;
            for (int v = 0; v < n; v++)
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        System.out.println("Shortest Distances:");
        for (int i = 0; i < n; i++) System.out.println(src + " -> " + i + " = " + dist[i]);
    }
}
