class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        int gcdOfNumbers = 0;
        for (int i : nums) {
            if (i == 1) {
                ones++;
            }
            gcdOfNumbers = gcd(gcdOfNumbers, i);
        }
        if (ones > 0) {
            return n - ones;
        }
        if (gcdOfNumbers > 1)
            return -1;
        int count = n;
        for (int i = 0; i < n; i++) {
            int current = 0;
            for (int j = i; j < n; j++) {
                current = gcd(current, nums[j]);
                if (current == 1) {
                    count = Math.min(count, j - i + 1);
                    break;
                }
            }
        }
        return count + n - 2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}