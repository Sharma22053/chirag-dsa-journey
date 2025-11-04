class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        List<Integer> rowTopo = topoSort(k, rowConditions);
        List<Integer> colTopo = topoSort(k, colConditions);
        if (rowTopo.size() == 0 || colTopo.size() == 0) {
            return new int[0][0];
        }
        int[][] result = new int[k][k];
         Map<Integer, Integer> colMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            colMap.put(colTopo.get(i), i);
        }

       
        Map<Integer, Integer> rowMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            rowMap.put(rowTopo.get(i), i);
        }

        for (int i = 1; i <= k; i++) {
            int r = rowMap.get(i);
            int c = colMap.get(i);
            result[r][c] = i;
        }
        return result;

    }

    private List<Integer> topoSort(int k, int[][] matrix) {
        List<List<Integer>> adj = buildGraph(k, matrix);
        Queue<Integer> queue = new ArrayDeque<>();
        int[] degree = new int[k+1];
        for (int[] edge : matrix) {
            int x = edge[1];
            degree[x]++;
        }
        for (int i = 1; i <= k; i++) {
            if (degree[i] == 0)
                queue.offer(i);
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            list.add(current);
            for (int neighbour : adj.get(current)) {
                degree[neighbour]--;
                if (degree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        if (list.size() != k)
            return new ArrayList<>();
        return list;
    }

    private List<List<Integer>> buildGraph(int k, int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <=k; i++) {
            result.add(new ArrayList<>());
        }

        for (int[] edge : matrix) {
            result.get(edge[0]).add(edge[1]);
        }
        return result;
    }
}