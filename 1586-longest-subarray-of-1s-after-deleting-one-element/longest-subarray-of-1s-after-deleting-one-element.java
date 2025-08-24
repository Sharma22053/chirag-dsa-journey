class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0,right =0 , n= nums.length,zeros= 0,window = 0;
        while(right < n){
            if(nums[right] == 0) zeros++;
            while(zeros > 1){
                if(nums[left] == 0) zeros--;
                left++;
            }
            window = Math.max(window,right-left);
            right++;
        }
        return window;
    }
}