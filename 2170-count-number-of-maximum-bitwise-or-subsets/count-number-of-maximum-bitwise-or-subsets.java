class Solution {
    public int countMaxOrSubsets(int[] nums) {
        if(nums.length == 0) return 0;
        int bitwiseOR = 0;
        for (int i = 0; i < nums.length; i++) {
            bitwiseOR |= nums[i];
        }

        return helper(0, bitwiseOR, nums, 0);

    }

    static int helper(int index, int bitwiseOR, int[] nums,
            int currentOR) {
        if (index == nums.length) {

            return currentOR == bitwiseOR ? 1 : 0;
        }

        int include = helper(index + 1, bitwiseOR, nums, currentOR | nums[index]);

        int exclude = helper(index + 1, bitwiseOR, nums, currentOR);

        return include + exclude;
    }

}