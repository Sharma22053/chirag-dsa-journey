class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = buildGraph(numCourses,prerequisites);
        int[] visit = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(visit[i] == 0 && dfs(i,adj,stack,visit)){
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i] = stack.pop();
        }
        return result;
        
    }


    private boolean dfs(int node,List<List<Integer>> adj,Stack<Integer> stack,int[] visit){
        if(visit[node] == 1) return true;
        if(visit[node] == 2) return false;
        visit[node] = 1;
        for(int i: adj.get(node)){
            if(dfs(i,adj,stack,visit)){
                return true;
            }
        }
        visit[node] = 2;
        stack.push(node);
        return false;
    }

    private List<List<Integer>> buildGraph(int numCourses,int[][] prerequisites){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());

        }

        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
}