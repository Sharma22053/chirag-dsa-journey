class Solution {
    int[][] dp;

    public int maxTwoEvents(int[][] events) {
        int rows = events.length, column = events[0].length;
        dp = new int[rows][3];
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        for (int[] edge : dp)
            Arrays.fill(edge, -1);
        return helper(events,0,0);
    }

    private int helper(int[][] events, int index, int count) {
        if (index >= events.length || count == 2)
            return 0;
        if (dp[index][count] != -1)
            return dp[index][count];
        int include = 0, exclude = 0;
        if (dp[index][count] == -1) {
            int end = events[index][1];
            int low = index + 1, high = events.length - 1;
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                if (events[mid][0] > end)
                    high = mid;
                else
                    low = mid + 1;
            }
            include = events[index][2]
                    + (low < events.length && events[low][0] > end ? helper(events, low, count + 1) : 0);
            exclude = helper(events, index + 1, count);
        }
        return dp[index][count] = Math.max(include, exclude);
    }
}