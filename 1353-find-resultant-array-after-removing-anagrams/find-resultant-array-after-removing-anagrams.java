class Solution {
    
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        for(String s : words){
            result.add(s);
        }
        int i=1;
        while(i<result.size()){
            String s1 = result.get(i);
            String s2 = result.get(i-1);
            if(isAnagram(s1,s2)){
                result.remove(s1);
                continue;
            }
            i++;
           
        }
        return result;
    }

    private boolean isAnagram(String s1, String s2){
        char[] s1Array =s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        return (new String(s1Array).equals(new String (s2Array))); 
    }
}