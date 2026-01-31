class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char[] temp = letters.clone();
        Arrays.sort(temp);
        char result = target;
        for(char ch : letters){
            if(ch > result){
                result = ch;
                break;
            }
        }
        if(result == target) return letters[0];
        return result;
    }
}