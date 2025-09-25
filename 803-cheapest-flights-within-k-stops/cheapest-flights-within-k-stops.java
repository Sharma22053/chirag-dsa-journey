class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {    
        List<List<int[]>> graph = new ArrayList<>();
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
    PriorityQueue<int[]> queue = new PriorityQueue<>( (a,b) -> Integer.compare(a[0],b[0]));
        queue.offer(new int[]{0,src,0});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cost = current[0];
            int node = current[1];
            int stop = current[2];
            if(node == dst) return cost;
            if(stop > k || stop >= distance[node]) continue;

            distance[node] = stop;
            for(int[] neighbour: graph.get(node)){
                int nextNode = neighbour[0] , price = neighbour[1];
                queue.offer(new int[]{price+cost,nextNode,stop+1});
            }

        }
        return -1;
    }
}