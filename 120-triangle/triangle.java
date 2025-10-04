class Solution {
    Integer[][] dp;
    int size;
    public int minimumTotal(List<List<Integer>> triangle) {
        size = triangle.size();
        dp= new Integer[size][size];
        return helper(triangle,0,0);
    }
    private int helper(List<List<Integer>> triangle,int row,int column){
       if(row == size) return 0;

       if(dp[row][column] != null) return dp[row][column];

       int left = triangle.get(row).get(column) + helper(triangle,row+1,column+1);
       int right = triangle.get(row).get(column) + helper(triangle,row+1,column);

       return dp[row][column] = Math.min(left,right);
    }
}