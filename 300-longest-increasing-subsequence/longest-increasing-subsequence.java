class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j = i-1;j >= -1;j--){
               int length = dp[i+1][j+1];
               if(j == -1 || nums[i] > nums[j]){
                length = Math.max(length , 1 + dp[i+1][i+1]);
               } 
               dp[i][j+1] = length;
            }
        }
        return dp[0][0];
    }
}