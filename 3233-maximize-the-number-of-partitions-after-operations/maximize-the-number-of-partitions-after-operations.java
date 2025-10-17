class Solution {
    Map<Long,Integer> hmap = new HashMap<>();
    String s;
    int k;
    private int helper(int index,long mask,boolean canChange){
        if(index == s.length()) return 0;
        long key = ((long)index << 27) | (mask<<1)| (canChange?1:0);

        if(hmap.containsKey(key))return hmap.get(key);

        int ch = s.charAt(index) - 'a';
        long newMask = mask | (1L<<ch);
        int result;

        if(Long.bitCount(newMask) > k){
            result = 1 + helper(index+1,1L<<ch,canChange);
        } else {
            result = helper(index+1,newMask,canChange);
        }

        if(canChange){
            for(int j=0;j<26;j++){
                long newChangeMask = mask |( 1L<< j);
                if(Long.bitCount(newChangeMask) > k){
                    result = Math.max(result,1+helper(index+1,1l<<j,false));
                } else {
                    result = Math.max(result,helper(index+1,newChangeMask,false));
                }
            }
        }
         hmap.put(key,result);
         return result;
    }
    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        return helper(0,0,true) + 1;
    }
}