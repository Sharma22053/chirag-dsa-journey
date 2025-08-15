class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0 , right = 0,count = 0;
        while(right < nums.length){
            if(nums[right] - nums[left] == 1){
                count = Math.max(count, right-left+1);
            }
            
                while(nums[right] - nums[left] > 1){
                    left++;
                }

            right++;
        }

        return count;
    }
}