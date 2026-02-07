class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int count = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                b++;
            } else if (b > 0) {
                count++;
                b--;
            }
        }
        return count;
    }
}