class Solution {
    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int numberOfRows = heightMap.length;
        int numberOfColumn = heightMap[0].length;

        boolean[][] visited = new boolean[numberOfRows][numberOfColumn];
        for (int i = 0; i < numberOfRows; i++) {
            queue.offer(new int[] { heightMap[i][0], i, 0 });
            queue.offer(new int[] { heightMap[i][numberOfColumn - 1], i, numberOfColumn - 1 });
            visited[i][0] = visited[i][numberOfColumn - 1] = true;
        }

        for (int i = 0; i < numberOfColumn; i++) {
            queue.offer(new int[] { heightMap[0][i], 0, i });
            queue.offer(new int[] { heightMap[numberOfRows - 1][i], numberOfRows - 1, i });
            visited[0][i] = visited[numberOfRows - 1][i] = true;
        }

        int volume = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int height = current[0];
            int row = current[1];
            int column = current[2];

            for (int[] dirs : directions) {
                int newRow = row + dirs[0];
                int newColumn = column + dirs[1];
                if (isValid(newRow, newColumn, numberOfRows, numberOfColumn) && !visited[newRow][newColumn]) {
                    visited[newRow][newColumn] = true;
                    int neighbourHeight = heightMap[newRow][newColumn];
                    if (neighbourHeight < height) {
                        volume += height - neighbourHeight;
                    }
                    queue.offer(new int[] { Math.max(neighbourHeight, height), newRow, newColumn });

                }
            }
        }
        return volume;

    }

    private boolean isValid(int row, int column, int numberOfRows, int numberOfColumn) {
        return row >= 0 && column >= 0 && row < numberOfRows && column < numberOfColumn;
    }
}