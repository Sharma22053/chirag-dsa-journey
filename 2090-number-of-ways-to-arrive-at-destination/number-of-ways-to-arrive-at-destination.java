class Solution {
    private int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] road: roads){
            graph.get(road[0]).add(new int[]{road[1],road[2]});
            graph.get(road[1]).add(new int[]{road[0],road[2]});
        }
        long[] distance = new long[n];
        int[] ways = new int[n];
        Arrays.fill(ways,0);
        Arrays.fill(distance,Long.MAX_VALUE);
        ways[0] = 1;
        distance[0] = 0;
        PriorityQueue<long[]> queue = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0]));
        queue.offer(new long[]{0,0});
        while(!queue.isEmpty()){
            long[] current = queue.poll();
            int node = (int)current[1];
            long currentDistance = current[0];
            if(distance[node] < currentDistance) continue;
            for(int[] neighbour : graph.get(node)){
                int nextNode = neighbour[0];
                int weight = neighbour[1];
                long newDist = weight + currentDistance;
                if(distance[nextNode] > newDist){
                    distance[nextNode] = newDist;
                    ways[nextNode] = ways[node];
                    queue.offer(new long[]{newDist , nextNode});
                } else if(newDist == distance[nextNode]){
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        return ways[n-1];
    
    }

}