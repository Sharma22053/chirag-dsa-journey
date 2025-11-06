class Solution {
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int column = mat[0].length;
        int[][] result = mat;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (result[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                } else {
                    result[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for(int[] dirs : directions){
                int newRow = r + dirs[0];
                int newColumn = c + dirs[1];
                if(newRow >= 0 && newColumn >= 0 && newRow < rows &&
                newColumn < column && result[newRow][newColumn] == -1){
                    result[newRow][newColumn] = 1 + result[r][c];
                    queue.offer(new int[] {newRow,newColumn});
                }
            }
        }
        return result;

    }
}