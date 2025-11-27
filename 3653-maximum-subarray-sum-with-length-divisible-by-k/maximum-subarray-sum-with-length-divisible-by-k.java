class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        long result = Long.MIN_VALUE;
        for(int start = 0;start <k;start++){
            long currentSum = 0;
            int i = start;
            while(i < n && i+k-1<n){
                int j = i+k-1;
             long subSum = prefixSum[j] - ((i > 0) ? prefixSum[i - 1] : 0);
                 currentSum = Math.max(currentSum+subSum,subSum);
                result = Math.max(result,currentSum);
                i+=k;
            }
        }
        return result;

    }
}
