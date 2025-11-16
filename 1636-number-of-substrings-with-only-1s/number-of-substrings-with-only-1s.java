class Solution {
    public int numSub(String s) {
        int mod = 1000000007;
        long result = 0;
        long continuous = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                continuous++;
                result = (result + continuous) % mod;
            } else {
                continuous = 0;
            }
        }
       
        return (int) result;

    }
}