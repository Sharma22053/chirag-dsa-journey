class Solution {
    public List<String> letterCombinations(String s) {
        if(s.length() == 0) return new ArrayList<>();
        HashMap<Character,String> hmap = new HashMap<>();
        hmap.put('2', "abc");
       hmap.put('3', "def");
       hmap.put('4', "ghi");
       hmap.put('5', "jkl");
       hmap.put('6', "mno");
       hmap.put('7', "pqrs");
       hmap.put('8', "tuv");
       hmap.put('9', "wxyz");
       List<String> result = new ArrayList<>();
       letterCombinations(result,new StringBuilder(),s,
       0,hmap);
       return result;

       
    }

    static void letterCombinations(List<String> result,StringBuilder temp,String s, int start,HashMap<Character,String> hmap){
        if(temp.length() == s.length()){
            result.add(new String(temp+""));
            return;
        }
         if(temp.length() > s.length()){return;}

         char ch = s.charAt(start);
         String st = hmap.get(ch);
         for(char c : st.toCharArray()){
            temp.append(c);
            letterCombinations(result,temp,s,start+1,hmap);
            temp.deleteCharAt(temp.length() -1);
         }
    }

}