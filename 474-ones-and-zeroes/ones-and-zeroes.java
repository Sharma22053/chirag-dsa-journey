class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];
        return helper(strs,0,m,n,dp);
    }
    private int helper(String[] strs,int index,int m,int n,int[][][] dp){
       if(index == strs.length) return 0;
       if(dp[index][m][n] != 0) return dp[index][m][n];

       int zeros = 0 , ones = 0;
       for(char ch : strs[index].toCharArray()){
        if(ch  == '0') zeros++;
        else ones++;
       }

       int leave = helper(strs,index+1,m,n,dp);
       int take = 0;
       if(m >= zeros && n>= ones){
        take = 1 + helper(strs,index+1,m-zeros,n-ones,dp);
       }

       return dp[index][m][n] = Math.max(take,leave);
    }

}