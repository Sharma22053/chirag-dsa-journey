class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int o = nums.get(i);
            int c = -1;
            for (int j = 1; j < o; j++) {
                if ((j | (j + 1)) == o) {
                    c = j;
                    break;
                }
            }
            result[i] = c;
        }
        return result;
    }
}