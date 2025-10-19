class Solution {
    Integer[][] dp;
    int newCutsArray[];
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        newCutsArray = new int[m+2];
        System.arraycopy(cuts,0,newCutsArray,1,m);
        newCutsArray[0] = 0;
        newCutsArray[m + 1] = n;
        Arrays.sort(newCutsArray);

        dp = new Integer[m+2][m+2];
        
        return helper(0,newCutsArray.length-1);
    }
    private int helper(int i,int j){
        if(j - i <=1) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for(int mid = i+1;mid<j;mid++){
            int cost = helper(i,mid) + helper(mid,j)+
            newCutsArray[j] - newCutsArray[i];
            mini = Math.min(cost,mini);
        }
        return dp[i][j] =mini;
    }

}