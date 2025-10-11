class Solution {
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[sLength + 1][tLength + 1];
        for (int i = 0; i <= sLength; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(s, t, sLength - 1, tLength - 1, dp);
    }

    private int helper(String s, String t, int i, int j, int[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = helper(s, t, i - 1, j - 1, dp) + helper(s, t, i - 1, j, dp);
        }

        return dp[i][j] = helper(s, t, i - 1, j, dp);
    }
}