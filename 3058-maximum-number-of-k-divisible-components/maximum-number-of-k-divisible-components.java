class Solution {
    int componentCount;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adjacency = adjacencyList(n, edges);
        componentCount = 0; 
        dfs(0,-1,adjacency,values,k);
        return componentCount;
    }
    private int dfs(int currentNode,int parentNode,List<List<Integer>> adjacency,int[] values,int k){ 
        int sum = 0;
        for(int neighbour : adjacency.get(currentNode)){
            if(neighbour != parentNode){
                sum += dfs(neighbour,currentNode,adjacency,values,k);
                sum %= k;
            }
        }
        sum += values[currentNode];
        sum %= k;

        if(sum == 0) componentCount++;
        return sum;
    }

    private List<List<Integer>> adjacencyList(int n, int[][] edges) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }
        return adjacency;
    }
}