class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][] dp = new long[k + 1][n];

        for (int t = 1; t <= k; t++) {
            long bestBuy = -prices[0];   // dp[t-1][-1] - prices[0] → treat dp[t-1][-1] as 0
            long bestSell = prices[0];   // dp[t-1][-1] + prices[0]

            for (int i = 1; i < n; i++) {
                // Option 1: do nothing today
                dp[t][i] = dp[t][i - 1];

                // Option 2: finish a transaction today
                dp[t][i] = Math.max(
                    dp[t][i],
                    Math.max(
                        bestBuy + prices[i],   // normal transaction
                        bestSell - prices[i]   // short selling
                    )
                );

                // Update helpers for next days
                bestBuy = Math.max(bestBuy, dp[t - 1][i - 1] - prices[i]);
                bestSell = Math.max(bestSell, dp[t - 1][i - 1] + prices[i]);
            }
        }
        return dp[k][n - 1];
    }
}
