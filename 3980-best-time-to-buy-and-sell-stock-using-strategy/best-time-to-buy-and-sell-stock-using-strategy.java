class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] prefix = new long[n + 1];
        long[] priceSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (long) prices[i] * strategy[i];
            priceSum[i + 1] = priceSum[i] + prices[i];
        }
        long result = prefix[n];
        for (int i = k - 1; i < n; i++) {
            long leftPrefix = prefix[i - k + 1];
            long rightPrefix = prefix[n] - prefix[i + 1];
            long change = priceSum[i + 1] - priceSum[i - k / 2 + 1];
            result = Math.max(result, leftPrefix + change + rightPrefix);
        }
        return result;
    }
}