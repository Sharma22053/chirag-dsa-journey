class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<List<Integer>> adjacency = buildGraph(relations, n);
        int[] indegree = new int[n+1];
        for(int[] edge : relations){
            indegree[edge[1]]++;
        }
        int[] finishTime = new int[n+1];
        for(int i=1;i<=n;i++){
            finishTime[i] = time[i-1];
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i : adjacency.get(node)){
                finishTime[i] = Math.max(finishTime[i],time[i-1]+finishTime[node]);
                indegree[i]--;
                if(indegree[i] == 0) queue.offer(i);
            }

        }
        for(int i=0;i<=n;i++){
            count = Math.max(count,finishTime[i]);
        }
        return count;

    }

    private ArrayList<List<Integer>> buildGraph(int[][] relations, int n) {

        ArrayList<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : relations) {
            adjacency.get(edge[0]).add(edge[1]);
        }
        return adjacency;
    }
}