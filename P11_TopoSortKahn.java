// 29. Travelling Salesperson Problem (TSP) using Backtracking
public class P29_TSP {
    static int n, minCost = Integer.MAX_VALUE;
    static int[][] cost = {
        {0,10,15,20},
        {10,0,35,25},
        {15,35,0,30},
        {20,25,30,0}
    };
    static boolean[] visited;

    static void tsp(int city, int count, int currCost) {
        if (count == n && cost[city][0] > 0) {
            minCost = Math.min(minCost, currCost + cost[city][0]);
            return;
        }
        for (int i = 0; i < n; i++)
            if (!visited[i] && cost[city][i] > 0) {
                visited[i] = true;
                tsp(i, count + 1, currCost + cost[city][i]);
                visited[i] = false;
            }
    }

    public static void main(String[] args) {
        n = cost.length;
        visited = new boolean[n];
        visited[0] = true;
        tsp(0, 1, 0);
        System.out.println("Minimum Cost = " + minCost);
    }
}
