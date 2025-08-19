class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long result = 0;
        int i =0;
        while(i < n){
            long length = 0;
            if(nums[i] == 0){
                while( i<n && nums[i] == 0){
                    i++;
                    length++;
                }
            } else {
                i++;
            }
            result += (length) * (length+1) / 2;
        }

        return result;
    }
}