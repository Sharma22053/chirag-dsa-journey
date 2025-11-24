class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<List<Integer>> adjacency = buildGraph(richer, n);

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = i;
        }
        int[] indegree = new int[n];
        for (int[] edge : richer) {
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : adjacency.get(node)) {
                if (quiet[answer[node]] < quiet[answer[i]]) {
                    answer[i] = answer[node];
                }
                indegree[i]--;
                if (indegree[i] == 0)
                    queue.offer(i);
            }
        }
        return answer;
    }

    private ArrayList<List<Integer>> buildGraph(int[][] richer, int n) {

        ArrayList<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : richer) {
            adjacency.get(edge[0]).add(edge[1]);
        }
        return adjacency;
    }
}