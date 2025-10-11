class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int lcsLength = helper(word1,word2,0,0);
        return (n+m) - 2 * lcsLength;
        
    }

    private int helper(String s1,String s2,int index1,int index2){
        if(index1 == s1.length() || index2 == s2.length()) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(s1.charAt(index1) == s2.charAt(index2)){
            return dp[index1][index2] = 1 + helper(s1,s2,index1+1,index2+1);
        }

        int notMatch = Math.max(helper(s1,s2,index1+1,index2) ,
        helper(s1,s2,index1,index2+1));

        return dp[index1][index2] = notMatch;
    }
}