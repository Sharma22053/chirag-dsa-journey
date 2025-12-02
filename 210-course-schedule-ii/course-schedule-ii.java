class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = buildGraph(prerequisites,numCourses);
        int[] inDegree = new int[numCourses];
        for(int[] edge : prerequisites){
            inDegree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            list.add(node);
            for(int neighbour : adjacency.get(node)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        if(list.size() != numCourses) return new int[0];
        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i] = list.get(i);
        }
        return result;
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