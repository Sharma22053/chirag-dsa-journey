class Solution {
    int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
    int fillColor;
    int initialColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] result = image;
        this.fillColor = color;
        this.initialColor = result[sr][sc];
        

        if (fillColor == initialColor)
            return image;

        dfs(result, sr, sc);
        return result;

    }

    private void dfs(int[][] result, int row, int col) {
        if (row < 0 || row >= result.length || col < 0 || col >= result[0].length || result[row][col] != initialColor) {
            return;
        }

       

        result[row][col] = fillColor;
        for (int[] dir : directions) {
            dfs(result, row + dir[0], col + dir[1]);
        }
    }
}