// DFS SOlution
class Solution {
    int directions[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowLength = heights.length;
        int columnLength = heights[0].length;
        boolean[][] pacific = new boolean[rowLength][columnLength];
        boolean[][] atlantic = new boolean[rowLength][columnLength];

        for(int i=0;i<rowLength;i++){
            dfs(i,0,heights,pacific);
            dfs(i,columnLength-1,heights,atlantic);
        }
        for(int i=0;i<columnLength;i++){
             dfs(0,i,heights,pacific);
            dfs(rowLength-1,i,heights,atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<columnLength;j++){
                if(atlantic[i][j] && pacific[i][j]) result.add(Arrays.asList(i,j));
            }
        }
    return result;
    }

    private void dfs(int row, int column, int[][] heights, boolean[][] visit) {
        if(visit[row][column]) return;
        visit[row][column] = true;
        for (int[] dirs : directions) {
            int newRow = dirs[0] + row;
            int newColumn = dirs[1] + column;
            if (isValid(newRow, newColumn, heights.length, heights[0].length) &&
                    !visit[newRow][newColumn] &&
                    heights[row][column] <= heights[newRow][newColumn]) {
                dfs(newRow, newColumn, heights, visit);
            }
        }
    }

    private boolean isValid(int row, int column, int rowLength, int columnLength) {
        return row >= 0 && column >= 0 &&
                row < rowLength && column < columnLength;
    }
}