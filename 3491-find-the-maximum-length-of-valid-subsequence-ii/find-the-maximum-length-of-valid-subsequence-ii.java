class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int maxLength = 0;

        for(int num : nums){
            int currentMod = num % k;
            for(int prevMod = 0; prevMod < k;prevMod++){
                dp[prevMod][currentMod] = dp[currentMod][prevMod] +1;
                maxLength = Math.max(dp[prevMod][currentMod],maxLength);
            }
        }

        return maxLength;
    }
}