class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int mex = 0;
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i : nums) {
            int mod = (((i % value) + value) % value);
            hmap.put(mod, hmap.getOrDefault(mod, 0) + 1);
        }
        while (true) {
            int toFound = mex % value;
            if (hmap.getOrDefault(toFound, 0) > 0) {
                hmap.put(toFound, hmap.get(toFound) - 1);
                mex++;
            } else {
                break;
            }
        }
        return mex;
    }
}
