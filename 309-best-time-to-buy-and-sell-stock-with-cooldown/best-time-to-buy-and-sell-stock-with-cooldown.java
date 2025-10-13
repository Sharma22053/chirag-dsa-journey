//Here buyOrSell is working like a flag if zero we can buy and if 1 we can sell
class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n+1][2];
        return helper(prices, 0, 0);
    }

    private int helper(int[] prices, int index, int buyOrSell) {
        if (index >= prices.length)
            return 0;
        if(dp[index][buyOrSell] != null) return dp[index][buyOrSell];

        int profit = 0;
        if (index < prices.length) {
            if (buyOrSell == 0) {
                int take = helper(prices, index + 1, 1) - prices[index];
                int leave = helper(prices, index + 1, 0);
                profit = Math.max(take, leave);
            } else {
                int take = helper(prices, index + 2, 0) + prices[index];
                int leave = helper(prices, index + 1, 1);
                profit = Math.max(take, leave);
            }

        }

        return dp[index][buyOrSell] = profit;
    }
}