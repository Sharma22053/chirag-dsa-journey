class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount+1];
        return helper(coins,amount,0);
    }
    private int helper(int[] coins,int target,int index){
        if(index == coins.length-1){
            if(target % coins[index] == 0) return 1;
            else return 0;
        }
        if(dp[index][target] != null) return dp[index][target];
        
        int take = 0;
        if(target >= coins[index]){
            take  = helper(coins,target-coins[index],index);
        }
        int leave = helper(coins,target,index+1);
        return dp[index][target] = leave + take;
    }
}