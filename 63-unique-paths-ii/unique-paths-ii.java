class Solution {
    int[][] directions = { { 0, 1 }, { 1, 0 } };
    Integer[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length , column = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[row-1][column-1] == 1){
            return 0;
        }
            
        dp = new Integer[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        return helper(0, 0, obstacleGrid.length, obstacleGrid[0].length, obstacleGrid);
    }

    private int helper(int row, int column, int rowLength, int columnLength, int[][] obstacleGrid) {
        if (row == rowLength - 1 && column == columnLength - 1)
            return 1;
        if (dp[row][column] != null)
            return dp[row][column];
        int paths = 0;

        for (int[] dirs : directions) {
            int newRow = row + dirs[0];
            int newColumn = column + dirs[1];
            if (isValid(newRow, newColumn, rowLength, columnLength) && obstacleGrid[newRow][newColumn] != 1) {
                paths += helper(newRow, newColumn, rowLength, columnLength, obstacleGrid);
            }
        }
        return dp[row][column] = paths;
    }

    private boolean isValid(int row, int column, int rowLength, int columnLength) {
        return row >= 0 && column >= 0 && row < rowLength && column < columnLength;
    }
}