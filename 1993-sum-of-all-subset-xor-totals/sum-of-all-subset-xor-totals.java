class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }

    private int helper(int[] nums, int index, int currentXOR){
        if(index == nums.length){
            return currentXOR;
        }

        int with = helper(nums,index+1,currentXOR^nums[index]);
        int without = helper(nums,index+1,currentXOR);
        return with+without;
    }
}