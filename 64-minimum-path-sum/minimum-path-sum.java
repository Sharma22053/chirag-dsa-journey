class Solution {
    int[][] directions = { { 0, 1 }, { 1, 0 } };
    Integer[][] dp;

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        dp = new Integer[row + 1][column + 1];
        return helper(0, 0, row, column, grid);
    }

    private int helper(int row, int column, int rowLength, int columnLength, int[][] grid) {
        if (row == rowLength - 1 && column == columnLength - 1) {
            return grid[row][column];
        }
        if (dp[row][column] != null)
            return dp[row][column];
        int sum = Integer.MAX_VALUE;
        for (int[] dirs : directions) {
            int newRow = row + dirs[0];
            int newColumn = column + dirs[1];
            if (isValid(newRow, newColumn, rowLength, columnLength)) {
                int currentSum = helper(newRow, newColumn, rowLength, columnLength, grid);
                sum = Math.min(sum, currentSum);
            }
        }
        return dp[row][column] = sum + grid[row][column];

    }

    private boolean isValid(int row, int column, int rowLength, int columnLength) {
        return row >= 0 && column >= 0 && row < rowLength && column < columnLength;
    }
}