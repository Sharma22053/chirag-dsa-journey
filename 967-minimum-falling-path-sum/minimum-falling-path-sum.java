class Solution {
    int[][] directions = { { 1, 0 }, { 1, 1 }, { 1, -1 } };
    Integer[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        dp = new Integer[rowLength + 1][columnLength + 1];
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < columnLength; i++) {
            sum = Math.min(helper(matrix, 0, i, rowLength, columnLength), sum);
        }
        return sum;
    }

    private int helper(int[][] matrix, int row, int column, int rowLength, int columnLength) {
        if (row >= rowLength - 1)
            return matrix[row][column];
        if (dp[row][column] != null)
            return dp[row][column];
        int sum = Integer.MAX_VALUE;
        for (int[] dirs : directions) {
            int newRow = dirs[0] + row;
            int newColumn = dirs[1] + column;
            if (isValid(newRow, newColumn, rowLength, columnLength)) {
                sum = Math.min(sum, helper(matrix, newRow, newColumn, rowLength, columnLength));
            }
        }
        return dp[row][column] = matrix[row][column] + sum;
    }

    private boolean isValid(int row, int column, int rowLength, int columnLength) {
        return row >= 0 && column >= 0 &&
                row < rowLength && column < columnLength;
    }
}