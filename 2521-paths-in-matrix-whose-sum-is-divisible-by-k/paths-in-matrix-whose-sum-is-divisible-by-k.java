class Solution {
    Integer[][][] dp;
    private static final int mod = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n][k];

        return helper(grid,0,0,k,grid[0][0]%k);
    }

    private int helper(int[][] grid, int row, int column, int k, int remainder) {
       int m = grid.length , n = grid[0].length;
        if (row == m - 1 && column == n - 1) {
            return remainder == 0 ? 1 : 0;
        }
        if(dp[row][column][remainder] != null) return dp[row][column][remainder];

        long ways = 0;
        if(row + 1 < m){
           int newRemainder = (remainder + grid[row+1][column])%k;
           ways += helper(grid,row+1,column,k,newRemainder);
        }

        if(column + 1 < n){
             int newRemainder = (remainder + grid[row][column+1])%k;
           ways += helper(grid,row,column+1,k,newRemainder);
        }

        ways = ways % mod;
        return dp[row][column][remainder] = (int)ways;

    }
}