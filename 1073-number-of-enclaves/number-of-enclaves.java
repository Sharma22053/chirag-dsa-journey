class Solution {
    int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visit = new boolean[row][column];

        for (int i = 0; i < column; i++) {
            if (grid[0][i] == 1 && !visit[0][i]) {
                dfs(0, i, grid, visit);
            }
            if (grid[row - 1][i] == 1 && !visit[row - 1][i]) {
                dfs(row - 1, i, grid, visit);

            }
        }

        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1 && !visit[i][0]) {
                dfs(i, 0, grid, visit);
            }
            if (grid[i][column - 1] == 1 && !visit[i][column - 1]) {
                dfs(i, column - 1, grid, visit);
            }
        }

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1 && !visit[i][j])
                    count++;
            }
        }

        return count;

    }

    private void dfs(int row, int column, int[][] grid, boolean[][] visit) {
        visit[row][column] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newColumn = column + dir[1];
            if (newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length
                    && !visit[newRow][newColumn] && grid[newRow][newColumn] == 1) {
                dfs(newRow, newColumn, grid, visit);
            }
        }
    }
}