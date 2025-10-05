class Solution {
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        dp = new Integer[rowLength+1][columnLength+1][columnLength+1];
        return helper(0, 0, columnLength - 1, grid, rowLength, columnLength);
    }

    public int helper(int i, int j1, int j2, int[][] grid, int rowLength, int columnLength) {
        if(j1 < 0 || j1 >= columnLength || j2<0 || j2>=columnLength){
            return (int) -1e9;
        }

        if (i == rowLength - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != null) return dp[i][j1][j2];

        int maximum = 0;
        int maxCherries = (int) -1e9;

        for(int d1 = -1;d1<=1;d1++){
            for(int d2 = -1;d2<=1;d2++){
                int value = 0;
                if( j1 == j2) value = grid[i][j1];
                else value = grid[i][j2] + grid[i][j1];

                value += helper(i+1,j1+d1,j2+d2,grid,rowLength,columnLength);
                maxCherries = Math.max(value,maxCherries);
            }
        }
        return dp[i][j1][j2] = maxCherries;
    }

    
}