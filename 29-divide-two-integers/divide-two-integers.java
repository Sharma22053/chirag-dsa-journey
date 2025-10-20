class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if(dividend == min && divisor == -1) return max;

        // Use long to handle overflow
        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);

        boolean sign = (dividend >= 0) == (divisor >= 0);

        int ans = 0;

        while (divid >= divis) {
            int count = 0;
            while (divid >= (divis << (count + 1))) {
                count++;
            }
            ans += (1 << count);
            divid -= (divis << count);
        }

        if (!sign) ans = -ans;

        // Clamp to integer range
        if (ans >= max) return max;
        if (ans <= min) return min;

        return ans;
    }
}