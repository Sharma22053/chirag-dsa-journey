class Solution {
    public int maxScore(int[] nums, int k) {
        int left = 0,right=0,n=nums.length,minSum = Integer.MAX_VALUE,windowSum = 0;
        int total = 0,windowSize = n-k;
        for(int i=0;i<n;i++){
            total += nums[i];
        }
        if(windowSize == 0) return total;
        while(right < n){
            windowSum += nums[right];
            if(right-left+1 > windowSize){
                windowSum -= nums[left];
                left++;
            }
            if(right-left+1 == windowSize){
                 minSum = Math.min(minSum,windowSum);
            }
            right++;
        }

        return total - minSum;
    }
}