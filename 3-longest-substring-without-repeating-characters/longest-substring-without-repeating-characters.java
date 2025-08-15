class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        int max = 0;
        int left = 0, right = 0;
        while(right < s.length()){
            char ch = s.charAt(right);

            while(hashSet.contains(ch)){
                hashSet.remove(s.charAt(left));
                left++;
            }

            hashSet.add(ch);
            max = Math.max(max,right-left+1);
            right++;
        }

        return max;
    }
}