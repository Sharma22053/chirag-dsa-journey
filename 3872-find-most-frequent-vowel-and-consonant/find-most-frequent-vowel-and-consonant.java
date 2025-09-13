class Solution {
    public int maxFreqSum(String s) {
        Map<Character,Integer> hmapVowel = new HashMap<>();
        Map<Character,Integer> hmapCon = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                hmapVowel.put(ch,hmapVowel.getOrDefault(ch,0) + 1);
            } else {
                hmapCon.put(ch,hmapCon.getOrDefault(ch,0) + 1);
            }
        }

    

        int maxVowel = 0,maxCon =0;
         int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : hmapVowel.entrySet()) {
            if (entry.getValue() > maxVowel) {
                maxVowel = entry.getValue();
            }
        }

        for (Map.Entry<Character, Integer> entry : hmapCon.entrySet()) {
            if (entry.getValue() > maxCon) {
                maxCon = entry.getValue();
                
            }
        }

        return maxCon + maxVowel;
    }
    private boolean isVowel(char ch){
        return "aeiou".indexOf(ch) != -1;
    }
}