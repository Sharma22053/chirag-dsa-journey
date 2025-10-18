class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int previous = Integer.MIN_VALUE;
        for(int num : nums){
           int current = Math.min(Math.max(num-k,previous+1) , num+k);
           if(current > previous){
            count++;
            previous = current;
           }
        }
        return count;
        
    }
}