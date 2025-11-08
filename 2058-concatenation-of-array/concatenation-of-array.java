class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[2*n];
        for(int i=0;i<n;i++){
            result[i] = nums[i];
        }
        for(int i=n;i<2*n;i++){
            result[i] = result[i%n];
        }
        return result;
    }
}