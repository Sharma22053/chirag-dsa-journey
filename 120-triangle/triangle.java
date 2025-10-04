class Solution {
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp= new Integer[201][201];
        return helper(triangle,0,0);
    }
    private int helper(List<List<Integer>> triangle,int index,int length){
        if(length >= triangle.size()){
            return 0;
        }
        if(dp[length][index] != null) return dp[length][index];

    int i = triangle.get(length).get(index) + helper(triangle,index,length+1);
    int iPlusOne = triangle.get(length).get(index) + helper(triangle,index+1,length+1);

    return dp[length][index] = Math.min(i,iPlusOne);
    }
}