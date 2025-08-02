class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for(String str: words){
            if(canBeFormed(str,allowed)){
                count++;
            }
        }

        return count;
    }

    static boolean canBeFormed(String str, String allowed){
        Map<Character,Integer> hmap = new HashMap<>();
        
        for(char c : allowed.toCharArray()){
            hmap.put(c,hmap.getOrDefault(c,0)+1);
        }

        for(char c : str.toCharArray()){
            if(!hmap.containsKey(c)){
                return false;
            }
            
        }

        return true;
    }
}