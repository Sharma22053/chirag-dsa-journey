class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0,0);
    }
    private int helper(int[] nums,int target,int index,int currentSum){
        if(index == nums.length){
            if(currentSum == target) return 1;
            else return 0;
        }
        int plus = helper(nums,target,index+1,currentSum+nums[index]);
        int minus = helper(nums,target,index+1,currentSum-nums[index]);
        return plus + minus;
    }
}