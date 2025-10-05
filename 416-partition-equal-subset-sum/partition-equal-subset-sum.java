class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        
        double totalSum = 0;
        for(int i: nums){
            totalSum += i;
        }
        dp = new Boolean[nums.length][(int)(totalSum+1)];
return helper(nums,0,totalSum/2,0);
    }

    private boolean helper(int[] nums,int index,double target,int currentSum){
        if(currentSum == target) return true;
        if(index >= nums.length || currentSum > target) return false;
        if(dp[index][currentSum] != null) return dp[index][currentSum];

        boolean take = helper(nums,index+1,target,currentSum+nums[index]);
        boolean leave = helper(nums,index+1,target,currentSum);

        return dp[index][currentSum]=take || leave;
    }
}