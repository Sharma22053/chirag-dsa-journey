class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = mat;
        int[][] directions = {{0,1},{-1,0},{0,-1},{1,0}};
        Queue<int[]> queue = new LinkedList<>();
       for(int i=0;i<mat.length;i++){
        for(int j = 0;j<mat[0].length;j++){
            if(result[i][j] == 0){
                queue.offer(new int[]{i,j});
            } else {
                result[i][j] = -1;
            }
        }
       }

       while(!queue.isEmpty()){
        int[] temp = queue.poll();
        int row = temp[0];
        int column = temp[1];
            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newColumn = column + dir[1];

                if(newRow >= 0 && newRow < result.length && newColumn>=0 && newColumn < result[0].length && result[newRow][newColumn] == -1){
                    result[newRow][newColumn] = result[row][column]+1;
                    queue.add(new int[] {newRow,newColumn});
                }
            }
       }
       return result;
    }
}