class Solution {
    public boolean isPowerOfThree(int n) {
       
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<=19;i++){
            hashSet.add((int)Math.pow(3,i));
        }

        return n > 0 && hashSet.contains(n);
    }
}