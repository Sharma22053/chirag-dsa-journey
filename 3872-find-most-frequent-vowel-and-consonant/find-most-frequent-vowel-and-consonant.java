class Solution {
    public int maxFreqSum(String s) {
        Map<Character,Integer> hmap = new HashMap<>();
        int maxVowel = 0,maxCon =0;

        for(char ch : s.toCharArray()){
            hmap.put(ch,hmap.getOrDefault(ch,0) + 1);
            int count = hmap.get(ch);
            if(isVowel(ch)){
                maxVowel = Math.max(maxVowel,count);
            } else {
                maxCon = Math.max(maxCon,count);
            }
        }

        return maxCon + maxVowel;
    }
    private boolean isVowel(char ch){
        return "aeiou".indexOf(ch) != -1;
    }
}