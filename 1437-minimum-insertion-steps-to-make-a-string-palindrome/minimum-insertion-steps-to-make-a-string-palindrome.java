class Solution {
    Integer[][] dp;
    public int minInsertions(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        dp = new Integer[s1.length() + 1][s2.length() +1];
        int longest = helper(s1,s2,0,0);
        return s.length() - longest;
    }

    private int helper(String s1,String s2,int index1,int index2){
        if(index1 == s1.length() || index2 == s2.length()){
            return 0;
        }

        if(dp[index1][index2] != null) return dp[index1][index2];

        if(s1.charAt(index1) == s2.charAt(index2)){
            return dp[index1][index2] = 1 + helper(s1,s2,index1+1,index2+1);
        }

        int notMatch = Math.max(helper(s1,s2,index1+1,index2) , 
        helper(s1,s2,index1,index2+1));
        return dp[index1][index2] = notMatch;
    }
}