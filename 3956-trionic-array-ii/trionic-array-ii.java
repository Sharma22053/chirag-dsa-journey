class Solution {
    long NEG = -100000000000000L;
    Long[][] dp;

    public long maxSumTrionic(int[] nums) {
        dp = new Long[nums.length][4];
        return helper(0, 0, nums.length, nums);
    }

    private long helper(int index, int trend, int n, int[] nums) {
        if (index == nums.length) {
            return trend == 3 ? 0 : NEG;
        }
        if (dp[index][trend] != null)
            return dp[index][trend];
        long take = NEG;
        long notTake = NEG;

        if (trend == 0) {
            notTake = helper(index + 1, 0, n, nums);
        }
        if (trend == 3) {
            take = nums[index];
        }

        if (index + 1 < n) {
            if (trend == 0 && nums[index + 1] > nums[index]) {
                take = Math.max(take, nums[index] + helper(index + 1, 1, n, nums));
            } else if (trend == 1) {
                if (nums[index + 1] > nums[index]) {
                    take = Math.max(take, nums[index] + helper(index + 1, 1, n, nums));
                } else if (nums[index + 1] < nums[index]) {
                    take = Math.max(take, nums[index] + helper(index + 1, 2, n, nums));
                }
            } else if (trend == 2) {
                if (nums[index + 1] < nums[index]) {
                    take = Math.max(take, nums[index] + helper(index + 1, 2, n, nums));
                } else if (nums[index + 1] > nums[index]) {
                    take = Math.max(take, nums[index] + helper(index + 1, 3, n, nums));
                }
            } else if (trend == 3 && nums[index + 1] > nums[index]) {
                take = Math.max(take, nums[index] + helper(index + 1, 3, n, nums));
            }
        }

        return dp[index][trend] = Math.max(take, notTake);
    }
}