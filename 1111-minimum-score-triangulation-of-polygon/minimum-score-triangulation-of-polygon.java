class Solution {
    int[][] dp;
    public int minScoreTriangulation(int[] values) {
        dp = new int[51][51];
        for(int i=0;i<51;i++){
            Arrays.fill(dp[i] ,-1);
        }
        return minimum(values,0,values.length-1);
    }
    private int minimum(int[] values,int i,int j){
        if(j-i+1 < 3) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int result = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int weight = minimum(values,i,k) +
            values[i]*values[j]*values[k] + minimum(values,k,j);
            result = Math.min(result,weight);
        }
    return dp[i][j] = result;
    }
}