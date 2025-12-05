class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0)
            return s;
        int left = 0;
        for (int right = n - 1; right >= 0; right--) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
            }
        }

        if (left == n)
            return s;
        String nonPal = s.substring(left);
        StringBuilder sb = new StringBuilder(nonPal).reverse();

        return sb.append(shortestPalindrome(s.substring(0, left))).append(nonPal).toString();
    }
}