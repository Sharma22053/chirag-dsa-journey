class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0, left = 0, zeros = 0, max = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] == 0)
                zeros++;
           
                while (zeros > k) {
                    if (nums[left] == 0)
                        zeros--;
                    left++;
                }                    
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}