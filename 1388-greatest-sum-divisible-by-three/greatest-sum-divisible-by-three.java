class Solution {
    Integer[][] dp;

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][3];
        return helper(0, 0, nums);
    }

    private int helper(int index, int mod, int[] nums) {
        if (index == nums.length)
            return mod == 0 ? 0 : Integer.MIN_VALUE;

        if (dp[index][mod] != null)
            return dp[index][mod];

        int leave = helper(index + 1, mod, nums);
        int newMod = (mod + nums[index]) % 3;
        int temp = helper(index + 1, newMod, nums);
        int take = (temp == Integer.MIN_VALUE) ? Integer.MIN_VALUE : nums[index] + temp;
        return dp[index][mod] = Math.max(take, leave);

    }
}