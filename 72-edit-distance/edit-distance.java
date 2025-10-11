class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();

        dp = new Integer[word1Length + 1][word2Length + 1];
        return helper(word1,word2,word1Length-1,word2Length-1);
    }

    private int helper(String word1,String word2, int index1,int index2){
       
        if(index1 < 0) return index2 + 1;
         if(index2 < 0) return index1 + 1;
        

        if(dp[index1][index2] != null) return dp[index1][index2];

        if(word1.charAt(index1) == word2.charAt(index2)){
            return dp[index1][index2] = helper(word1,word2,index1 - 1,index2 - 1);
        }

        int insert = 1 + helper(word1,word2,index1,index2-1);
        int delete = 1 + helper(word1,word2,index1-1,index2);
        int replace = 1 + helper(word1,word2,index1-1,index2-1);

        return dp[index1][index2] = Math.min(insert,Math.min(replace,delete));
    }
}