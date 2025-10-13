class Solution {
    Integer[][][] dp;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2][k + 1];
        return helper(prices, k, 0, 0, 0);
    }

    private int helper(int[] prices, int k, int index, int transactionCount, int buyOrSell) {
        if (index == prices.length)
            return 0;
        if (dp[index][buyOrSell][transactionCount] != null)
            return dp[index][buyOrSell][transactionCount];

        int profit = 0;
        if (transactionCount < k) {
            if (buyOrSell == 0) {
                int take = helper(prices, k, index + 1, transactionCount, 1) - prices[index];
                int leave = helper(prices, k, index + 1, transactionCount, 0);
                profit = Math.max(take, leave);
            } else {
                int leave = helper(prices, k, index + 1, transactionCount, 1);
                int take = helper(prices, k, index + 1, transactionCount + 1, 0) + prices[index];
                profit = Math.max(take, leave);
            }
        }
        return dp[index][buyOrSell][transactionCount] = profit;
    }
}