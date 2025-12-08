class Solution {
    public int countTriples(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int s = i * i + j * j;
                int k = (int) Math.sqrt(s);
                if (k <= n && k * k == s) {
                    result++;
                }
            }
        }
        return result;
    }
}