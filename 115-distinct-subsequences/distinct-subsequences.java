class Solution {
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        int[][] dp = new int[sLength+1][tLength+1];

        for(int i=0;i<=sLength;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=sLength;i++){
            for(int j=1;j<=tLength;j++){
                if(i == 0) dp[i][j] = 0;
                if(j == 0) dp[i][j] = 1;
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[sLength][tLength];
    }
}