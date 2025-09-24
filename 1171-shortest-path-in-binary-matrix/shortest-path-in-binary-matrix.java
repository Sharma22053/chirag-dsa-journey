class Solution {
    int[][] directions = {{0,1} ,{1,0},{0,-1},
    {-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int size = grid.length;
        if(grid[0][0] == 1 || grid[size-1][size-1] == 1) return -1;
        if(size == 1) return 1;
        boolean[][] visit = new boolean[size][size];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1});
        visit[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int column = current[1];
            int distance = current[2];

            if(row == size-1 && column == size-1) return distance;
            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newColumn = column + dir[1];

                if(newRow >= 0 && newRow < size && newColumn >= 0 &&
                newColumn < size && !visit[newRow][newColumn] &&
                grid[newRow][newColumn] == 0){
                    visit[newRow][newColumn] = true;
                    queue.add(new int[]{newRow,newColumn,distance+1});
                }
            }
        }

        return -1;

    }
}