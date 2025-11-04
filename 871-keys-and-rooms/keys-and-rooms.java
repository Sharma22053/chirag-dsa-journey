class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[rooms.size()];
        int count = 0;
        for(int i=0;i<rooms.size();i++){
            if(!visit[i]){
                dfs(rooms,i,visit);
                count++;
            }
        }
        return count == 1;

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