class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() +1];
        return helper(s,p,s.length(),p.length());
    }
    private boolean helper(String s,String p,int i , int j){
      
        if(i == 0 && j== 0) return dp[i][j] = true;
        if(j==0) return dp[i][j] = false;
        if(i == 0){
            for(int k=0;k< j;k++){
                if(p.charAt(k) != '*') return dp[i][j] = false;
            }
            return dp[i][j] = true;
        }
          if(dp[i][j] != null) return dp[i][j];

        if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?'){
            return dp[i][j] = helper(s,p,i-1,j-1);
        }
        if(p.charAt(j-1) == '*'){
            return dp[i][j] = helper(s,p,i-1,j) || helper(s,p,i,j-1);
        }

        return dp[i][j] = false;
    }
}