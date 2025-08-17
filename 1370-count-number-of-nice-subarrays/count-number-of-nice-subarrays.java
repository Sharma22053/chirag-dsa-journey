class Solution {
    static int atMost(int[] nums, int k) {
        int left = 0, right = 0 , n = nums.length, sum =0 ,count = 0;
        while(right < n){
            sum += nums[right] % 2;
            while(sum > k){
                sum -= nums[left]%2;
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;
    }
      public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
      }
}