class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> hmap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        boolean odd = false;
        for (int frequency : hmap.values()) {
            if ((frequency % 2) == 0) {
                count += frequency;
            } else {
                count += frequency - 1;
                odd = true;
            }
        }
        if (odd)
            return count + 1;
        return count;
    }
}