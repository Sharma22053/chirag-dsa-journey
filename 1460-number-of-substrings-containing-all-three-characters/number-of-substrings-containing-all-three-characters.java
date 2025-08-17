class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0,right = 0,n = s.length(),count = 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        while(right < n){
            char ch = s.charAt(right);
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
            while(hmap.containsKey('a') && hmap.containsKey('b') && hmap.containsKey('c')){
                count += n - right;
                char charac = s.charAt(left);
                hmap.put(charac,hmap.get(charac) -1);
                if(hmap.get(charac) == 0){
                    hmap.remove(charac);
                }
                left++;
            }

            
            right++;
        }

        return count;
    }
}