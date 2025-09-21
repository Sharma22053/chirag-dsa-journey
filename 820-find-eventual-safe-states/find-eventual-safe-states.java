class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
       
        List<Integer> result = new LinkedList<>();
        

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph,state)) {
                result.add(i);
            }
        }
        return result;

    }

    private boolean dfs(int node, int[][] graph, int[] state) {
       if(state[node] == 1) return false;
       if(state[node] == 2) return true;

       state[node] = 1;
        for (int neighbour : graph[node]) {
            if (!dfs(neighbour,graph,state))
                return false;
        }
        state[node] = 2;
        return true;
    }
}