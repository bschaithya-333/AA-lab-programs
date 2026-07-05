// 28. 0/1 Knapsack Problem using Dynamic Programming
public class P28_KnapsackDP {
    public static void main(String[] args) {
        int[] wt = {20, 40, 80};
        int[] val = {100, 120, 200};
        int W = 110, n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++)
            for (int w = 1; w <= W; w++)
                dp[i][w] = (wt[i - 1] <= w)
                    ? Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w])
                    : dp[i - 1][w];

        System.out.println("Maximum Profit = " + dp[n][W]);
    }
}
