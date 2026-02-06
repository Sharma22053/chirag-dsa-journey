class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1)
            return 0;
        Arrays.sort(nums);
        int i = 0, maxWindow = 1;
        for (int j = 0; j < n; j++) {
            while (i <= j && (long) nums[j] > (long) nums[i] * (long) k)
                i++;
            maxWindow = Math.max(maxWindow, j - i + 1);
        }
        return n - maxWindow;
    }
}