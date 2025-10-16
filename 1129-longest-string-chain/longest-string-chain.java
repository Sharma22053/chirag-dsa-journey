class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (compare(words[j], words[i]) && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    private boolean compare(String s1, String s2) {
        if (s2.length() - s1.length() != 1) return false;
            
        boolean skipped = false;
        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (skipped)
                    return false;
                skipped = true;
                j++;
            }
        }
        return true;
    }
}