class Solution {
    public int characterReplacement(String s, int k) {
        int front = 0;
        int maxLength = 0;
        int[] count = new int[26];
        int maxCount = 0;
        int back = 0;
        int n = s.length();

        while(back < n){
            char c = s.charAt(back);
            count[c - 'A']++;
            maxCount = Math.max(maxCount , count[c - 'A']);

            while(back-front+1 - maxCount > k){
                count[s.charAt(front) - 'A']--;
                front++;
            }

            maxLength = Math.max(maxLength, back-front+1);
            back++;
        }

        return maxLength;
    }
}