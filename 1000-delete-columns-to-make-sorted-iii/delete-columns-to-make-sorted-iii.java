class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int[] dp = new int[strs[0].length()];
        Arrays.fill(dp, 1);
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < i; j++) {
                boolean flag = true;

                for (int r = 0; r < n; r++) {
                    if (strs[r].charAt(j) > strs[r].charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int x : dp) {
            ans = Math.max(x, ans);
        }
        return strs[0].length() - ans;
    }
}