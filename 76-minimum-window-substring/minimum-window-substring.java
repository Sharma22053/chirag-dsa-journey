class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> have = new HashMap<>();
        for(char ch : t.toCharArray()){            
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        int required = need.size();
        int formed = 0;
        int right =0,left=0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
             have.put(ch,have.getOrDefault(ch,0)+1);
             if(need.containsKey(ch) && have.get(ch).intValue() == need.get(ch).intValue()){
                formed++;
             }
            while(left <= right && formed == required){
                if(right - left+1 < minLength){
                    minLength = right-left+1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                have.put(leftChar,have.get(leftChar) -1);
            if(need.containsKey(leftChar) && have.get(leftChar) <need.get(leftChar)){
                formed--;
            }
            left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start,start+minLength);
    }
}