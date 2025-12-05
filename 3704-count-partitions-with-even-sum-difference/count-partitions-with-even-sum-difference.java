class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0 , n = nums.length;
        for(int i : nums) sum += i;
        return sum % 2 == 0 ? n-1 : 0;
    }
}