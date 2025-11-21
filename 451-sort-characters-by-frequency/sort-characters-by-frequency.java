class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<s.length();i++){
            hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)+1);
        }

        ArrayList<Character> chars = new ArrayList<>(hmap.keySet());
        chars.sort((a,b) -> hmap.get(b) - hmap.get(a));

        for(char c: chars){
            int frequency = hmap.get(c);
            for(int i =0;i<frequency;i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}