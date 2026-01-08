class Solution {
    int[][] dp;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        dp = new int[n1][n2];
        for (int i = 0; i < n1; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        return helper(nums1, nums2, 0, 0);

    }

    private int helper(int[] a, int[] b, int i, int j) {
        if (i == a.length || j == b.length) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int take = a[i] * b[j];

        int bestWithPair = take;
        int diag = helper(a, b, i + 1, j + 1);
        if (diag != Integer.MIN_VALUE) {
            bestWithPair = Math.max(bestWithPair, take + diag);
        }

        
        int skipA = helper(a, b, i + 1, j);
        int skipB = helper(a, b, i, j + 1);

        int res = bestWithPair;
        if (skipA != Integer.MIN_VALUE)
            res = Math.max(res, skipA);
        if (skipB != Integer.MIN_VALUE)
            res = Math.max(res, skipB);

        return dp[i][j] = res;

    }
}