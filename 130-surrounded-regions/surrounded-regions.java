class Solution {
    public void solve(char[][] board) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int rows = board.length;
        int column = board[0].length;
        boolean[][] visit = new boolean[rows][column];
        
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++){
        if ((i == 0 || j == 0 || i == rows-1 || j == column-1) && board[i][j] == 'O'){
            queue.offer(new int[]{i,j});
            board[i][j] = '#';
        }
            }
        }

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentColumn = current[1];
            for(int[] dirs : directions){
                int newRow = currentRow + dirs[0];
                int newColumn = currentColumn + dirs[1];
                if(isValid(newRow,newColumn,rows,column) && 
                  board[newRow][newColumn] == 'O'){
                   
                     board[newRow][newColumn] = '#';
                     queue.offer(new int[] {newRow,newColumn});
                  }
            }
        }
        
for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }

    }
    private boolean isValid(int r, int c, int rows,int column){
        return r>=0 && c>=0 && r<rows && c < column;
    }

}