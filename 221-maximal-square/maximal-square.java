class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[rows][column];
        int count = 0;

        for(int i=0;i<rows;i++){
            for(int j =0;j<column;j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                count = Math.max(count,dp[i][j]);
            }
        }
        return count * count;
    }
}