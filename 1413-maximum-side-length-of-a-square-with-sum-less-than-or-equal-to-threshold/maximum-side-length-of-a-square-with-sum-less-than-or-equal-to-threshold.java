class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int row = mat.length;
        int column = mat[0].length;
        int[][] p = new int[row + 1][column + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                p[i][j] = mat[i - 1][j - 1] + p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1];

            }
        }
        int result = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                int len = result + 1;
                if (i >= len && j >= len) {
                    int r1 = i - len + 1;
                    int c1 = j - len + 1;
                    int total = p[i][j] - p[r1 - 1][j] - p[i][c1 - 1] + p[r1 - 1][c1 - 1];
                    if (total <= threshold) {
                        result++;
                    }
                }
            }
        }
        return result;

    }
}