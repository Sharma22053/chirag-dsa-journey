class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;
        int rows = grid.length;
        int column = grid[0].length;
        boolean[][] visit = new boolean[rows][column];
        for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++){
                if(i == 0 || i == rows-1 || j == 0 || j == column -1){
                    if(grid[i][j] == 1){
                    queue.offer(new int[] {i,j});
                    visit[i][j] = true;
                }
                }
                
            }
        }
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int[] dirs : directions){
                int newRow = dirs[0] + current[0];
                int newColumn = dirs[1] + current[1];
                if(isValid(newRow,newColumn,rows,column) && grid[newRow][newColumn] == 1 && !visit[newRow][newColumn]){
                    visit[newRow][newColumn] = true;
                    queue.offer(new int[] {newRow,newColumn});

                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++){
                if(visit[i][j] == false && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;

    }
    private boolean isValid(int r,int c,int rows,int column){
        return r>=0 && c>=0 && r<rows && c< column;
    }
}