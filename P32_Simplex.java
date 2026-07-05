// 1. Assignment Problem using Brute Force
import java.util.*;
public class P01_Assignment {
    static int n, minCost = Integer.MAX_VALUE;
    static int[][] cost = {{9,2,7,8},{6,4,3,7},{5,8,1,8},{7,6,9,4}};
    static int[] best;

    static void solve(int worker, boolean[] used, int[] assign, int total) {
        if (worker == n) {
            if (total < minCost) { minCost = total; best = assign.clone(); }
            return;
        }
        for (int job = 0; job < n; job++) {
            if (!used[job]) {
                used[job] = true;
                assign[worker] = job;
                solve(worker + 1, used, assign, total + cost[worker][job]);
                used[job] = false;
            }
        }
    }

    public static void main(String[] args) {
        n = cost.length;
        solve(0, new boolean[n], new int[n], 0);
        System.out.println("Minimum Cost = " + minCost);
        for (int i = 0; i < n; i++)
            System.out.println("Worker " + i + " -> Job " + best[i]);
    }
}
