class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int remainder = nums[i] % 3;
            count += Math.min(remainder,3-remainder);
        }
        return count;
    }
}