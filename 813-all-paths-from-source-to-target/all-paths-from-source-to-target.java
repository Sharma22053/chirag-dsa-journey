class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        helper(graph,result,0,path);
        return result;
    }

    private void helper(int[][] graph,List<List<Integer>> result,int node,List<Integer> temp){
        if(node == graph.length -1){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int neighbour : graph[node]){
            temp.add(neighbour);
            helper(graph,result,neighbour,temp);
            temp.remove(temp.size()-1);
        }


    }
}