class Solution {
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return helper(prices, 0, 0);
    }

    private int helper(int[] prices, int index, int buy) {
        if (index == prices.length)
            return 0;

        if (dp[index][buy] != null)
            return dp[index][buy];
        int profit = 0;
        if (buy == 0) {
            profit = Math.max(helper(prices, index + 1, 0), helper(prices, index + 1, 1) - prices[index]);
        } else {
            profit = Math.max(helper(prices, index + 1, 1), prices[index] + helper(prices, index + 1, 0));
        }
        return dp[index][buy] = profit;
    }
}