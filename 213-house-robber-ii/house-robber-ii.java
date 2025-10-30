class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] dp = new int[n + 2];
        for (int i = n - 2; i >= 0; i--) {
            int leave = dp[i + 1];
            int take = nums[i] + dp[i + 2];
            dp[i] = Math.max(take, leave);
        }
        int first = dp[0];
        dp = new int[n + 2];
        for (int i = n - 1; i >= 1; i--) {
            int leave = dp[i + 1];
            int take = 0;

            take = nums[i] + dp[i + 2];

            dp[i] = Math.max(take, leave);
        }
        int second = dp[1];
        return Math.max(first, second);
    }
}