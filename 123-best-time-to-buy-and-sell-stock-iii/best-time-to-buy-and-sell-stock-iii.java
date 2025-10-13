class Solution {
    Integer[][][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n + 1][2][3];
        return helper(prices, 0, 0, 0);
    }

    private int helper(int[] prices, int index, int buy, int transactionCount) {
        if (index == prices.length)
            return 0;
        if (dp[index][buy][transactionCount] != null)
            return dp[index][buy][transactionCount];

        int profit = 0;
        if (buy == 0 && transactionCount < 2) {
            int take = helper(prices, index + 1, 1, transactionCount) - prices[index];
            int leave = helper(prices, index + 1, 0, transactionCount);
            profit = Math.max(take, leave);
        } else if (buy == 1 && transactionCount < 2) {
            int take = helper(prices, index + 1, 0, transactionCount + 1) + prices[index];
            int leave = helper(prices, index + 1, 1, transactionCount);
            profit = Math.max(take, leave);
        }
        return dp[index][buy][transactionCount] = profit;
    }
}