class Solution {
    Integer[] dp;
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        dp = new Integer[n+1];
        int result = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            result = Math.max(result,helper(energy,k,i));
        }
        return result;
    }

    private int helper(int[] energy,int k,int index){
        if(index >= energy.length) return 0;
        if(dp[index] != null) return dp[index];

        int gain = energy[index] + (index + k < energy.length? helper(energy,k,index+k):0);
        return dp[index] = gain;
    }
}