class Solution {
    int[] dp;
    String temp;
    public int numDecodings(String s) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp,-1);
        temp = new String(s);
        return helper(0);
    }
    private int helper(int index){
        if(index == temp.length()) return 1;
        if(temp.charAt(index) == '0') return 0;
        if(dp[index] != -1) return dp[index];

        int leave = helper(index+1);
        int take = 0;
        if(index + 1 < temp.length()){
            int twoDigit = Integer.parseInt(temp.substring(index,index+2));
          if(twoDigit >= 10 && twoDigit <= 26){
            take += helper(index+2);
          }
        }
        return dp[index] = leave + take;
    }
}