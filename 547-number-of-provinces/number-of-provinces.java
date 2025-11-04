class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visit = new boolean[n];
        List<List<Integer>> adjacencyList = buildAdjacency(isConnected);
        int count =0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(adjacencyList,i,visit);
                count++;
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> adjacencyList,int node,boolean[] visit){
        visit[node] = true;
        for(int neighbour : adjacencyList.get(node)){
            if(!visit[neighbour]){
                dfs(adjacencyList,neighbour,visit);
            }
        }
    }

    private List<List<Integer>> buildAdjacency(int[][] isConnected) {
        List<List<Integer>> result = new ArrayList<>();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    result.get(i).add(j);
                    result.get(j).add(i);
                }

            }
        }
        return result;
    }
}