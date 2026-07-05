// 6. Floyd-Warshall Algorithm (All-Pairs Shortest Path)
public class P06_FloydWarshall {
    public static void main(String[] args) {
        int INF = 999;
        int[][] dist = {
            {0, 3, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };
        int n = dist.length;
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        System.out.println("Shortest Path Matrix :");
        for (int[] row : dist) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }
}
