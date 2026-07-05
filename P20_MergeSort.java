// 23. Prim's Algorithm (Minimum Spanning Tree)
public class P23_Prims {
    public static void main(String[] args) {
        int[][] cost = {
            {0,3,0,5,10},
            {3,0,6,7,0},
            {0,6,0,1,8},
            {5,7,1,0,2},
            {10,0,8,2,0}
        };
        int n = cost.length;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int edgesCount = 0, minCost = 0;
        System.out.println("Edges in MST:");
        while (edgesCount < n - 1) {
            int min = Integer.MAX_VALUE, a = -1, b = -1;
            for (int i = 0; i < n; i++)
                if (visited[i])
                    for (int j = 0; j < n; j++)
                        if (!visited[j] && cost[i][j] != 0 && cost[i][j] < min) { min = cost[i][j]; a = i; b = j; }
            System.out.println(a + " - " + b + " : " + min);
            minCost += min;
            visited[b] = true;
            edgesCount++;
        }
        System.out.println("Minimum Cost = " + minCost);
    }
}
