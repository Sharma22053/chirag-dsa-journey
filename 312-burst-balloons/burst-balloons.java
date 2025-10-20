class Solution {
    Integer[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n+1] = 1;
        for(int i=1;i<=n;i++){
            arr[i] = nums[i-1];
        }
        dp = new Integer[n+2][n+2];
        return helper(arr,0,n+1);
    }
    private int helper(int[] arr,int i,int j){
        if(i + 1 ==j) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int cost =Integer.MIN_VALUE;
        for(int k=i+1;k<j;k++){
            int temp = arr[i] * arr[k] * arr[j] + helper(arr,i,k) + helper(arr,k,j);
            cost = Math.max(cost,temp);
        }
        return dp[i][j] = cost;
    }
}