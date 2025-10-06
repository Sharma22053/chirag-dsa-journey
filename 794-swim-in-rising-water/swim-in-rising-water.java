class Solution {
    int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{grid[0][0],0,0});
        visited[0][0] = true;
        int time = 0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            time = Math.max(time,current[0]);
            int row = current[1];
            int column = current[2];

            if(row == n-1 && column == n-1) return time;
            for(int[] dirs : directions){
                int newRow = dirs[0] + row;
                int newColumn = dirs[1] + column;
                if(isValid(newRow,newColumn,n) && !visited[newRow][newColumn]){
                queue.offer(new int[]{grid[newRow][newColumn],newRow,newColumn});
                visited[newRow][newColumn] = true;
                }
            }
        }
        return -1;

    }

    private boolean isValid(int row,int column , int n){
        return row>=0 && column>=0 && row<n && column <n;
    }
}
