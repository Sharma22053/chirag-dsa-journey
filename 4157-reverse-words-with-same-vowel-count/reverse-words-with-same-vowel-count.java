class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        int firstVowelCount = countVowel(str[0]);
        for (int i = 1; i < str.length; i++) {
            if(countVowel(str[i]) == firstVowelCount){
                str[i] = new StringBuilder(str[i]).reverse().toString();
            }
        }
        return String.join(" ",str);

    }

    private int countVowel(String str) {
        int count = 0;
        String vowel = "aeiou";
        for (char ch : str.toCharArray()) {
            if (vowel.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}