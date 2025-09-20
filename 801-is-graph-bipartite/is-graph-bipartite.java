class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0;i<color.length;i++){
            if(color[i] == 0 && !dfs(i,graph,color,1)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node,int[][] graph,int[] color,int toFill){
        color[node] = toFill;
        for(int i : graph[node]){
            if(color[i] == 0 && !dfs(i,graph,color,-toFill)){
                return false;
            } else if(color[i] == toFill) return false;
        }
        return true;
    }
}