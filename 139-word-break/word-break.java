class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return isPresent(s,wordDict,memo,0);
    }

    static boolean isPresent(String s,List<String> wordDict,Boolean[] memo,int index){
        if(index == s.length()) return true;
        if(memo[index] != null) return memo[index];
        for(int i=index;i<s.length();i++){
            String str = s.substring(index,i+1);
            if(wordDict.contains(str) && isPresent(s,wordDict,memo,i+1)){
            return memo[index] = true;
            }
        }
        return memo[index] = false;
    }
}