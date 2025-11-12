class Solution {
    public boolean isBipartite(int[][] graph) {
        int row = graph.length;
        int column = graph[0].length;
        int[] colors = new int[row];
        Arrays.fill(colors,-1);
        for(int i=0;i<row;i++){
           if(colors[i] == -1){
             Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        colors[i] = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : graph[node]){
                if(colors[neighbour] == -1){
                    colors[neighbour] = 1 - colors[node];
                    queue.offer(neighbour);
                }
                else if(colors[neighbour] == colors[node]){
                    return false;
                }
            }
        }
           }
        }
        return true;
    }
}