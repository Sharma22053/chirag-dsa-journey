class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visit[i]){
                numberOfComponents++;
                dfs(i,isConnected,visit);
            }
        }

        return numberOfComponents;
    }

    private void dfs(int node,int[][] isConnected,boolean[] visit){
        visit[node] = true;

        for(int i =0;i<isConnected.length;i++){
            if(!visit[i] && isConnected[node][i] == 1){
                dfs(i,isConnected,visit);
            }
        }
    }

}