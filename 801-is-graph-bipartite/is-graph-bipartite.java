class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !dfs(graph, i, 0, color)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node, int c, int[] color) {
        color[node] = c;
        for (int neighbour : graph[node]) {
            if (color[neighbour] == -1) {

                if (!dfs(graph, neighbour, 1 - c, color))
                    return false;

            } else if (color[neighbour] == color[node])
                return false;
        }
        return true;
    }
}