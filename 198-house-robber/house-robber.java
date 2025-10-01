class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length+1];
        return helper(nums,0,dp);
    }
    private int helper(int[] nums,int i,Integer[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != null) return dp[i];

        int take = nums[i] + helper(nums,i+2,dp);
        int notTake = helper(nums,i+1,dp);
        return dp[i] = Math.max(take,notTake);
    }
}