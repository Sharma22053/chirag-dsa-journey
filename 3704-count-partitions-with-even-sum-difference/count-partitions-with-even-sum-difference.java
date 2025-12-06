class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).
        reduce(0,(a,b) -> a + b);
        return sum % 2 == 0 ? n-1 : 0;
    }
}