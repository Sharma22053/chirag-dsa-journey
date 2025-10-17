class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxi = 1 , result = 0;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i=1;i<n;i++){
            for(int j =0;j<i;j++ ){
              if(nums[i] > nums[j]) {
                if(dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                    count[i] = count[j];
                } else if (dp[i] == 1 + dp[j]){
                    count[i] += count[j];
                }
              }          
              }
            maxi = Math.max(maxi,dp[i]);
        }

        for(int i=0;i<n;i++){
            if(maxi == dp[i]) result += count[i];
        }
        return result;
    }
}