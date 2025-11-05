class Solution {
    int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visit = grid;
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int freshCount = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        if (freshCount == 0)
            return 0;
        if (queue.size() == 0)
            return -1;
        int minutes = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int column = current[1];

                for (int[] dirs : directions) {
                    int newRow = dirs[0] + row;
                    int newColumn = dirs[1] + column;
                    if (isValid(newRow, newColumn, rowLength, columnLength) && visit[newRow][newColumn] == 1) {
                        freshCount--;
                        queue.offer(new int[] { newRow, newColumn });
                        visit[newRow][newColumn] = 2;
                    }
                }
            }

        }
        if (freshCount != 0)
            return -1;
        return minutes;

    }

    private boolean isValid(int row, int column, int rowLength, int columnLength) {
        return row >= 0 && column >= 0 && row < rowLength && column < columnLength;
    }
}