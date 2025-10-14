class Solution {
    Integer[][] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n + 1];
        return helper(nums, 0, -1);
    }

    private int helper(int[] nums, int index, int previousIndex) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index][previousIndex + 1] != null)
            return dp[index][previousIndex + 1];
        int take = 0;

        if (previousIndex == -1 || nums[index] > nums[previousIndex]) {
            take = helper(nums, index + 1, index) + 1;
        }
        int leave = helper(nums, index + 1, previousIndex);
        return dp[index][previousIndex + 1] = Math.max(take, leave);
    }
}