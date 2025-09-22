class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = buildGraph(prerequisites,numCourses);
        int[] visit = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visit[i] == 0 && dfs(i,visit,adj)){
                return false;
            }
        }
        return true;

    }
    private boolean dfs(int node,int[] visit,ArrayList<ArrayList<Integer>> adj){
        if(visit[node] == 1) return true;
        if(visit[node] == 2) return false;
        visit[node] = 1;
        for(int i: adj.get(node)){
            if( dfs(i,visit,adj)){
                return true;
            }
        }
        visit[node] = 2;
        return false;
    }




    private ArrayList<ArrayList<Integer>> buildGraph(int[][] prerequisites,int numCourses){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;

    }
}