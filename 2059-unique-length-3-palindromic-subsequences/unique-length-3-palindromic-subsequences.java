class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Map<Character, Pair> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!hmap.containsKey(c)) {
                hmap.put(c, new Pair(i, i));
            } else {
                hmap.get(c).lastIndex = i;
            }
        }
        int count = 0;
        for (char ch : hmap.keySet()) {

            int first = hmap.get(ch).startIndex;
            int last = hmap.get(ch).lastIndex;
            if (first == last)
                continue;
            Set<Character> set = new HashSet<>();
            for (int i = first + 1; i < last; i++) {
                set.add(s.charAt(i));
            }
            count += set.size();

        }
        return count;
    }
}

class Pair {
    int startIndex;
    int lastIndex;

    Pair(int startIndex, int lastIndex) {
        this.startIndex = startIndex;
        this.lastIndex = lastIndex;
    }
}