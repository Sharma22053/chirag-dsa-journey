class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visit = new int[n];
        for(int i=0;i<n;i++){
            if(visit[i] == 0 && !dfs(i,graph,visit,1)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node,int[][] graph,int[] visit,int toFill){
        
        visit[node] = toFill;
        for(int i : graph[node]){
            if((visit[i] == 0 && !dfs(i,graph,visit,-toFill)) || visit[i] == toFill){
                return false;
            } 
        }
        return true;
    }
}