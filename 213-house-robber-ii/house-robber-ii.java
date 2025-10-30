class Solution {
    int[] temp;
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        temp = nums.clone();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int one = helper(0, nums.length - 2);
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int two = helper(1, nums.length - 1);
        return Math.max(one, two);
    }

    private int helper(int index, int last) {
        if (index >= last + 1)
            return 0;
        if (dp[index] != -1)
            return dp[index];

        int leave = helper(index + 1, last);
        int take = temp[index] + helper(index + 2, last);
        return dp[index] = Math.max(take, leave);

    }
}