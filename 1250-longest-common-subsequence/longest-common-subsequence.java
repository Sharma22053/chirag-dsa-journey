class Solution {
    Integer[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length() + 1][text2.length() + 1];
        return helper(text1, text2, 0, 0);
    }

    private int helper(String text1, String text2, int index1, int index2) {
        if (index1 == text1.length() || index2 == text2.length())
            return 0;
        if (dp[index1][index2] != null)
            return dp[index1][index2];

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return dp[index1][index2] = 1 + helper(text1, text2, index1 + 1, index2 + 1);
        }

        int notMatch = Math.max(helper(text1, text2, index1 + 1, index2),
                helper(text1, text2, index1, index2 + 1));

        return dp[index1][index2] = notMatch;
    }
}