class Solution {
    String string1;
    String string2;
    Boolean[][] dp;

    public boolean isSubsequence(String s, String t) {
        string1 = new String(s);
        string2 = new String(t);
        int string1Length = s.length(), string2Length = t.length();
        dp = new Boolean[string1Length + 1][string2Length + 1];

        return helper(0, 0);
    }

    private boolean helper(int index1, int index2) {
        if (index1 == string1.length())
            return true;
        if (index2 == string2.length())
            return false;
        if (dp[index1][index2] != null)
            return dp[index1][index2];

        if (string1.charAt(index1) == string2.charAt(index2)) {
            return dp[index1][index2] = helper(index1 + 1, index2 + 1);
        } else {
            return dp[index1][index2] = helper(index1, index2 + 1);
        }

    }
}