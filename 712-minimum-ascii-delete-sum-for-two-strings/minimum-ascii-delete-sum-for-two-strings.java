class Solution {
    String s1, s2;
    Integer[][] dp;

    public int minimumDeleteSum(String a, String b) {
        dp = new Integer[a.length()][b.length()];
        this.s1 = a;
        this.s2 = b;
        return helper(0, 0);
    }

    private int helper(int index1, int index2) {
        if (index1 == s1.length()) {
            int sum = 0;
            for (int i = index2; i < s2.length(); i++) {
                sum += s2.charAt(i);
            }
            return sum;
        }

        if (index2 == s2.length()) {
            int sum = 0;
            for (int i = index1; i < s1.length(); i++) {
                sum += s1.charAt(i);
            }
            return sum;
        }
        if (dp[index1][index2] != null)
            return dp[index1][index2];

        if (s1.charAt(index1) == s2.charAt(index2)) {
            dp[index1][index2] = helper(index1 + 1, index2 + 1);
        } else {
            int del1 = s1.charAt(index1) + helper(index1+1, index2 );
            int del2 = s2.charAt(index2) + helper(index1, index2 + 1);
            dp[index1][index2] = Math.min(del1, del2);
        }

        return dp[index1][index2];
    }
}