class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int o = nums.get(i);
            int c = -1;
            int d = 1;
            while ((o & d) != 0) {
                c = o - d;
                d <<= 1;
            }
            result[i] = c;
        }
        return result;
    }
}