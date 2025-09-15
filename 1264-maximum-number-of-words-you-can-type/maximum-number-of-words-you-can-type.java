class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for(char ch : brokenLetters.toCharArray()){
            set.add(ch);
        }
int count =0;
        String[] words = text.split(" ");
        for(String str : words){
            boolean ok = true;
            for(char c : str.toCharArray()){
                if(set.contains(c)){
                    ok = false;
                    break;
                }
            }
            if(ok) count++;
        }
        return count;

    }
}