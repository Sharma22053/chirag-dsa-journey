class Solution {
    int[][] directions = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        boolean[][] visit = new boolean[m][n];
        char[][] matrix = new char[m][n];

        for (int i = 0; i < guards.length; i++) {
            int[] current = guards[i];
            int row = current[0];
            int column = current[1];
            matrix[row][column] = 'G';
        }

        for (int i = 0; i < walls.length; i++) {
            int[] current = walls[i];
            int row = current[0];
            int column = current[1];
            matrix[row][column] = 'W';
        }

        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            visit[row][col] = true;

            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                while (isValid(r, c, m, n) && matrix[r][c] != 'W' && matrix[r][c] != 'G') {
                    visit[r][c] = true;
                    r += dir[0];
                    c += dir[1];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && matrix[i][j] != 'G' && matrix[i][j] != 'W') {
                    count++;
                }
            }
        }
        return count;

    }

    private boolean isValid(int row, int column, int m, int n) {
        return row >= 0 && column >= 0 && row < m && column < n;
    }
}