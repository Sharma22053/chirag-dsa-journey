class Solution {
    private int helper(int[] nums, int goal) {
        int left = 0,right = 0,n = nums.length,sum = 0,count = 0;
        while(right < n){
            sum += nums[right];
            while(sum > goal && left <= right){
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal) - helper(nums,goal-1);
    }
}