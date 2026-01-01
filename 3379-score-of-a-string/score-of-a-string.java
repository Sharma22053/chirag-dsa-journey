class Solution {
    public int scoreOfString(String s) {
        int count = 0;
        for (int i = 0; i < s.length()-1; i++) {
            count += Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        return count;
    }
}