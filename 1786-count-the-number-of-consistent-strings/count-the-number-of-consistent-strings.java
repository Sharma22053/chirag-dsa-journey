class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }

        int count =0;
        for(String str: words){
            int flag = 1;
            for(int i=0;i<str.length();i++){
                if(!set.contains(str.charAt(i))){
                    flag = 0;
                    break;
                }
            }

            count += flag;
        }

        return count;
    }
}