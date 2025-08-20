class Solution {
    public int countSquares(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (A[i][j] == 1 && i > 0 && j > 0) {
                    A[i][j] = Math.min(
                        A[i - 1][j - 1],
                        Math.min(A[i - 1][j], A[i][j - 1])
                    ) + 1;
                }
                res += A[i][j];
            }
        }

        return res;
    }
}