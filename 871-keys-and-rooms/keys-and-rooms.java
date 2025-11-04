class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[rooms.size()];
        dfs(rooms,0,visit);
        for(boolean b : visit){
            if(!b) return false;
        }
        return true;

    }
    private void dfs(List<List<Integer>> rooms,int node,boolean[] visit){
        visit[node] = true;
        for(int neighbour : rooms.get(node)){
            if(!visit[neighbour]){
                dfs(rooms,neighbour,visit);
            }
        }
    }

}