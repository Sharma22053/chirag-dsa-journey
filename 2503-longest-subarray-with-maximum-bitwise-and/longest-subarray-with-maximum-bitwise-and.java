class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int i : nums){
            if(i>max){
                max = i;
            }
        }

        int currentLength = 0;
        int maxLength = 0;
        for(int x : nums){
            if(x == max){
                currentLength++;
                maxLength = Math.max(currentLength, maxLength);
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }
}