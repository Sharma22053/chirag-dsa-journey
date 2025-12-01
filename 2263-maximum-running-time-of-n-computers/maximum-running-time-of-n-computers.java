class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long maximum = 0;
        long sum = 0;
        for (int i : batteries) {
            if (i > maximum) {
                maximum = i;
            }
            sum += i;
        }
        long low = 0;
        long result = 0;
        long high = sum / n;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (possible(batteries, mid, n)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return result;
    }

    private boolean possible(int[] batteries, long mid, int n) {
        long target = n * mid;
        long sum = 0;
        for (int i = 0; i < batteries.length; i++) {
            sum += Math.min(batteries[i] , mid);
            if(sum >= target) return true;
        }
        return false;
    }
}