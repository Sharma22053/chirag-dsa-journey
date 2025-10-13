class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String previous = "";

        for(String word : words){
            String current = getCanonical(word);
            if(!current.equals(previous)){
                result.add(word);
                previous = current;
            }
        }
        return result;
    }

    private String getCanonical(String current){
        char[] ch = current.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}