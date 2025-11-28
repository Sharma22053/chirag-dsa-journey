class Solution {
    int count;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adjacency = buildAdjacency(n,edges);
        count =0;
        dfs(0,-1,adjacency,values,k);
        return count;
    }
    private int dfs(int currentNode,int parentNode,List<List<Integer>> adjacency,int[] values,int k){
        int sum = values[currentNode];
        for(int neighbour : adjacency.get(currentNode)){
            if(neighbour != parentNode){
                sum += dfs(neighbour,currentNode,adjacency,values,k);
                sum %= k;
            }
        }
        sum %= k;
        if(sum == 0)count++;
        
        return sum;
    }

    private List<List<Integer>> buildAdjacency(int n, int[][] edges) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacency.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adjacency.get(node1).add(node2);
            adjacency.get(node2).add(node1);
        }
        return adjacency;
    }
}