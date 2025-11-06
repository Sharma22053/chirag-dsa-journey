class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];
        return helper(prices,0,0);

    }
    private int helper(int[] prices,int index,int buy){
        if(index == prices.length) return 0;
        if(dp[index][buy] != null) return dp[index][buy];
        int profit = 0;
        if(buy == 0){
            int leave = helper(prices,index+1,0);
            int take = helper(prices,index+1,1) - prices[index];
            profit = Math.max(leave,take);
        } else {
            int leave = helper(prices,index+1,1);
            int take = prices[index] + helper(prices,index+1,0);
            profit = Math.max(leave,take);

        }
        return dp[index][buy] = profit;
    }

}