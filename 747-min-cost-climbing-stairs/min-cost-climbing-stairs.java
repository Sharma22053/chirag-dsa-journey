class Solution {
    int[] temp;
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        temp = cost.clone();
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int zero = helper(0);
        int one = helper(1);
        return Math.min(zero, one);
    }

    private int helper(int index) {
        if (index >= temp.length)
            return 0;
        if (dp[index] != -1)
            return dp[index];

        return dp[index] = temp[index] + Math.min(helper(index + 1), helper(index + 2));
    }
}