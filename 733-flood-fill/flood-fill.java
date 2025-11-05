class Solution {
    int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColour = image[sr][sc];
        if (initialColour == color) return image;

        int m = image.length;
        int n = image[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newC >= 0 && newR < m && newC < n && image[newR][newC] == initialColour) {
                    image[newR][newC] = color;
                    queue.offer(new int[] {newR, newC});
                }
            }
        }
        return image;
    }
}
