class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] adj = new ArrayList[n];
        int[][] shortestMatrix = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(shortestMatrix[i],Integer.MAX_VALUE);
            shortestMatrix[i][i] = 0;
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            adj[start].add(new int[]{end,weight});
            adj[end].add(new int[]{start,weight});
        }

        for(int i=0;i<n;i++){
            dijkstra(n,adj,shortestMatrix[i],i);
        }

        return getSmallest(n,shortestMatrix,distanceThreshold);
    }

    private void dijkstra(int n,List<int[]>[] adj,int[] shortestMatrix,int source){
    PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
    queue.offer(new int[] {source,0});
    Arrays.fill(shortestMatrix,Integer.MAX_VALUE);
    shortestMatrix[source] = 0;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentCity = current[0];
            int currentDistance = current[1];

            if(shortestMatrix[currentCity] < currentDistance) continue;
            for(int[] neighbour : adj[currentCity]){
                int to = neighbour[0];
                int nextDistance = neighbour[1];
                if(shortestMatrix[to] > currentDistance + nextDistance){
                    shortestMatrix[to] = currentDistance + nextDistance;
                    queue.offer(new int[]{to,shortestMatrix[to]});
                }
            }
        }
    }

    private int getSmallest(int n,int[][] shortestMatrix,int threshold){
        int fewestR = -1;
        int reachC = n;

        for(int i=0;i<n;i++){
            int rc =0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(shortestMatrix[i][j] <= threshold){
                    rc++;
                }
            }
            if(rc <= reachC){
                reachC = rc;
                fewestR = i;
            }
        }
        return fewestR;

    }
}