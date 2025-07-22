class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i =0;
        int j = 0;
        int currSum =0;
        int maxSum = 0;
        while(j < nums.length){
            if(!set.contains(nums[j])){
                set.add(nums[j]);
                currSum += nums[j];
                maxSum = Math.max(currSum,maxSum);
                j++;
            } else{
                set.remove(nums[i]);
                currSum -=nums[i];
                i++;
                
            }
        }
        
        return maxSum;
    }
}