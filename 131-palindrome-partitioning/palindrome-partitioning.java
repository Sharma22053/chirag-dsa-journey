class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        generate(result,new ArrayList<>(),0,s);
        return result;

    }

    static void generate( List<List<String>> result,ArrayList<String> temp,
    int index,String s){
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i= index;i<s.length();i++){
            String substring = s.substring(index,i+1);
            if(isPalindrome(substring)){
            temp.add(substring);
            generate(result,temp,i+1,s);
            temp.remove(temp.size() -1);
            }

        }
        

    }

    static boolean isPalindrome(String s){
        int n = s.length();
       
        int i=0;
        int j = n-1;
        while(i<j){
           
                if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }

        }

        return true;
    }
}