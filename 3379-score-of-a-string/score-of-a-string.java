class Solution {
    public int scoreOfString(String s) {
        int count = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int number1 = s.charAt(i) - 'a';
            int number2 = s.charAt(i+1) - 'a';
            int temp = Math.abs(number1 - number2);
            count += temp;
        }
        return count;
    }
}