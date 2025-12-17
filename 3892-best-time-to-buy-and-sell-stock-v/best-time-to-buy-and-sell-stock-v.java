class Solution {
    private int[] prices;
    private Long[][][] dp;

    public long maximumProfit(int[] prices, int k) {
        this.prices = prices;
        int n = prices.length;
        dp = new Long[n][k + 1][3];
        
        return helper(n - 1, k, 0);
    }

    private long helper(int index, int k, int state) {
        if (k == 0)
            return 0;
        if (index == 0)
            return state == 0 ? 0 : (state == 1 ? -prices[0] : prices[0]);
        if (dp[index][k][state] != null)
            return dp[index][k][state];

        int p = prices[index];
        long result;
        if (state == 0) {
            result = Math.max(helper(index-1,k,0) , Math.max(helper(index - 1, k, 1) + p, helper(index - 1, k, 2) - p));
        } else if (state == 1) {
            result = Math.max(helper(index - 1, k, 1), helper(index - 1, k - 1, 0) - p);
        } else {
            result = Math.max(helper(index - 1, k, 2), helper(index - 1, k - 1, 0) + p);
        }
        return dp[index][k][state] = result;
    }
}