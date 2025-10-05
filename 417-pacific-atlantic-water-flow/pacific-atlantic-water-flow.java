//BFS Solution
class Solution {
    int directions[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int row = heights.length, column = heights[0].length;
        boolean[][] pacific = new boolean[row][column];
        boolean[][] atlantic = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            bfs(i, 0, pacific, heights);
            bfs(i, column - 1, atlantic, heights);
        }

        for (int i = 0; i < column; i++) {
            bfs(0, i, pacific, heights);
            bfs(row - 1, i, atlantic, heights);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int row, int column, boolean[][] visit, int[][] heights) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { row, column });
        visit[row][column] = true;
        int rowLength = heights.length, columnLength = heights[0].length;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];
            for (int[] dirs : directions) {
                int newRow = dirs[0] + r;
                int newCol = dirs[1] + c;
                if (isValid(newRow, newCol, rowLength, columnLength) && !visit[newRow][newCol]
                        && heights[newRow][newCol] >= heights[r][c]) {
                    visit[newRow][newCol] = true;
                    queue.add(new int[] { newRow, newCol });
                }

            }
        }
    }

    private boolean isValid(int row, int column, int rowLength, int columnLength) {
        return row >= 0 && column >= 0 &&
                row < rowLength && column < columnLength;
    }
}