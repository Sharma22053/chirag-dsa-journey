class Solution {
   Integer[][] dp;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new Integer[n][2];
        return helper(prices,0,0,fee);
    }
    private int helper(int[] prices,int index,int flag,int fee){
        if(index == prices.length) return 0;
        if(dp[index][flag] != null) return dp[index][flag];

        int profit = 0;
        if(flag == 0){
            int take = helper(prices,index+1,1,fee) - prices[index];
            int leave = helper(prices,index+1,0,fee);
            profit = Math.max(take,leave);
        } else {
            int take = helper(prices,index+1,0,fee) + prices[index] - fee;
            int leave = helper(prices,index+1,1,fee);
            profit = Math.max(take,leave);
        }
        return dp[index][flag] = profit;
    }
}