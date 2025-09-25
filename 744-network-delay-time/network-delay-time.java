class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time : times){
            graph.get(time[0]-1).add(new int[]{time[1]-1,time[2]});
        }
        
        int[] time = new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        queue.offer(new int[]{0,k-1});
        time[k-1] = 0;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int timeTaken = current[0];
            int node = current[1];
            if(time[node] < timeTaken) continue;
            for(int[] neighbour : graph.get(node)){
                int nextNode = neighbour[0];
                int nextNodeTime = neighbour[1];
                if(time[nextNode] > nextNodeTime + timeTaken){
                    time[nextNode] = nextNodeTime + timeTaken;
                    queue.offer(new int[]{time[nextNode] , nextNode});
                }
            }

        }
        int max = 0;

        for(int d : time){
            if(d== Integer.MAX_VALUE) return -1;
            max = Math.max(d,max);
        }
        return max;
    }
}