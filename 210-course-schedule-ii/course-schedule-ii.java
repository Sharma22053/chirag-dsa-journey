class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = buildGraph(prerequisites,numCourses);
        Stack<Integer> stack = new Stack<>();
        int[] visit = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visit[i] == 0 && dfs(i,adjacency,visit,stack)){
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i] = stack.pop();
        }
        return result;
    }
    private boolean dfs(int node,List<List<Integer>> adjacency,int[] visit,
    Stack<Integer> stack){
        if(visit[node] == 1) return true;
        if(visit[node] == 2) return false;
        visit[node] = 1;
        for(int i : adjacency.get(node)){
            if(dfs(i,adjacency,visit,stack)) return true;
        }
        visit[node]=2;
        stack.push(node);
        return false;

    }

    private List<List<Integer>> buildGraph(int[][] prerequisites,int numCourses){
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            result.add(new ArrayList<>());
        }

        for(int[] nodes : prerequisites){
            result.get(nodes[1]).add(nodes[0]);
        }
        return result;
    }
}