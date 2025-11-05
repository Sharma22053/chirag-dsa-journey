class Solution {
    int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int initialColour;
    int fillColour;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] result = image;
        this.initialColour = result[sr][sc];
        this.fillColour = color;

        if (fillColour == initialColour)
            return image;
        dfs(result,sr,sc);
        return result;

    }

    private void dfs(int[][] result, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= result.length || sc >= result[0].length || result[sr][sc] != initialColour)
            return;
        result[sr][sc] = fillColour;
        for (int[] dirs : directions) {
            dfs(result, sr + dirs[0], sc + dirs[1]);
        }
    }
}