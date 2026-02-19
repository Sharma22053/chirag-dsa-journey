class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0 , prev = 0 , current = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) != s.charAt(i)){
                count += Math.min(prev,current);
                prev = current;
                current = 1;

            }else{
                current++;
            }
        }
        return count + Math.min(prev,current);
    }
}