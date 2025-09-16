class Solution {
    public int orangesRotting(int[][] grid) {
        int countFresh = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] visit = grid;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visit[i][j] == 2) queue.offer(new int[] {i,j});
                if(visit[i][j] == 1) countFresh++;
            }
        }

        if(countFresh == 0) return 0;
        if(queue.isEmpty()) return -1;
        int minutes = -1;
        int[][] directions = {{1,0} , {-1,0} , {0,-1}, {0,1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            while( size-- > 0){
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for(int[] dir : directions){
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if(i >= 0 && i<m && j>=0 && j<n && visit[i][j] == 1){
                        visit[i][j] = 2;
                        countFresh--;
                        queue.offer(new int[]{i,j});
                    }
                }
            }
            minutes++;
        }
        if(countFresh == 0) return minutes;
        return -1;
        

    }
    
}