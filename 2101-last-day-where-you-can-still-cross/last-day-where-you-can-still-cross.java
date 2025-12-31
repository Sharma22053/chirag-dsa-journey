class Solution {
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int rows, cols;

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.rows = row;
        this.cols = col;

        int low = 1, high = cells.length, count = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (bfs(mid, cells)) {
                count = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return count;
    }

    private boolean bfs(int day, int[][] cells) {
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[rows][cols];

        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[] { 0, i });
                visit[0][i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            if (r == grid.length - 1)
                return true;
            for (int[] dirs : directions) {
                int newRow = dirs[0] + r;
                int newColumn = dirs[1] + c;
                if (isValid(newRow, newColumn, grid.length, grid[0].length) &&
                        !visit[newRow][newColumn] && grid[newRow][newColumn] == 0) {
                    queue.offer(new int[] { newRow, newColumn });
                    visit[newRow][newColumn] = true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int newRow, int newColumn, int rowLength, int columnLength) {
        return newRow >= 0 && newColumn >= 0 && newRow < rowLength && newColumn < columnLength;
    }
}