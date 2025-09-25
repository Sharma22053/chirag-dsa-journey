class Solution {
    int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int rows = heights.length , columns = heights[0].length;
        int[][] distance = new int[rows][columns];
        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        queue.offer(new int[] { 0, 0, 0 });
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int effort = node[0];
            int row = node[1];
            int column = node[2];
            if(row == heights.length -1 && column == heights[0].length-1) return effort;
            for (int[] dir : directions) {
                int newRow = dir[0] + row;
                int newColumn = dir[1] + column;
                if (newRow >= 0 && newRow < heights.length && newColumn >= 0 && newColumn < heights[0].length) {
                    int difference = Math.abs(heights[newRow][newColumn] - heights[row][column]);
                    int newEffort = Math.max(effort,difference);
                    if(distance[newRow][newColumn] > newEffort){
                        distance[newRow][newColumn] = newEffort;
                        queue.offer(new int[]{newEffort,newRow,newColumn});

                    }
                }
            }
        }
        return -1;

    }
}