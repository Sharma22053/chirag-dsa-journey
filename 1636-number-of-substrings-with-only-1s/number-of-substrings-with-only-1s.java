class Solution {
    public int numSub(String s) {
        int mod = 1000000007;
        long result = 0;
        long ones = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                ones++;
                result = (result + ones) % mod;
            } else {
                ones = 0;
            }
        }
       
        return (int) result;

    }
}