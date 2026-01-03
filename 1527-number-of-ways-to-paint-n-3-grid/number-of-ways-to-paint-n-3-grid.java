class Solution {
     static final int mod = 1000000007; 
    static String[] states = { "RYG", "RGY", "RYR", "RGR", "YRG", "YGR", "YGY", "YRY", "GRY", "GYR", "GRG", "GYG" };
    static Integer[][] dp;
    public int numOfWays(int n) {
        dp = new Integer[n][12];
        int result = 0;
        for (int i = 0; i < 12; i++) {
            result = (result + helper(n - 1, i)) % mod;
        }
        return result;
    }

    private int helper(int n , int previous){
        if(n == 0) return 1;
        if(dp[n][previous] != null) return dp[n][previous];
        int result  = 0;
        String last = states[previous];
        for(int current = 0;current < 12;current++){
            if(current == previous) continue;
            String currentPattern = states[current];
            boolean conflict = false;
            for(int column = 0;column<3;column++){
                if(currentPattern.charAt(column) == last.charAt(column)){
                    conflict = true;
                }
            }
            if(!conflict){
                result = (result + helper(n-1,current)) % mod;
            }
        }
        return dp[n][previous]=result;
    }
}