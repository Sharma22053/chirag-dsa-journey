class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length][amount+1];
        int result = helper(coins,amount,0);
         return result >= (int)Math.pow(10,9) ? -1 : result;
    }
    private int helper(int[] coins,int target,int index){
         if(index == coins.length) return target == 0 ? 0 : (int)Math.pow(10,9);
        if(dp[index][target] != null) return dp[index][target];
        int take = (int)Math.pow(10,9);
        if(coins[index] <= target){
            take = 1 + helper(coins,target-coins[index],index);
        }
        int leave = helper(coins,target,index+1);
        return dp[index][target] = Math.min(take,leave);
    }
}