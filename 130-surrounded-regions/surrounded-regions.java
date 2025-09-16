class Solution {
    int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i, visited, m, n);
        }

        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O')
                dfs(board, i, m - 1, visited, m, n);
        }
        for (int i = 0; i < m; i++) {
            if (board[n - 1][i] == 'O')
                dfs(board, n - 1, i, visited, m, n);
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0, visited, m, n);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0)
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int row, int col, int[][] visited, int m, int n) {
        visited[row][col] = 1;

        for (int[] dir : directions) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                    && board[newRow][newCol] == 'O' && visited[newRow][newCol] == 0) {
                dfs(board, newRow, newCol, visited, m, n);

            }

        }
    }
}
