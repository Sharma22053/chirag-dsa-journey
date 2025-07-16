class Solution {
    public int maximumLength(int[] nums) {
        int countEven = 0, countOdd = 0;
        int alternating = 1;
        int n = nums.length;

        int prevParity = nums[0] % 2;
        if (prevParity == 0) countEven++;
        else countOdd++;

        for (int i = 1; i < n; i++) {
            int currentParity = nums[i] % 2;

            
            if (currentParity == 0) countEven++;
            else countOdd++;

            
            if (currentParity != prevParity) {
                alternating++;
                prevParity = currentParity;
            }
        }

        return Math.max(Math.max(countEven, countOdd), alternating);
    }
}
