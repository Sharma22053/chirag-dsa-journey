class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) ->
        Integer.compare(a[0] , b[0]));
        for(int[] row : intervals){
            pq.add(row);
        }

        ArrayList<int[]> list = new ArrayList<>();
        int[] prev = pq.poll();
        for(int i=1;i<intervals.length;i++){
            int[] interval = pq.poll();
            if(interval[0] <= prev[1]){
                prev[1] = Math.max(prev[1],interval[1]);
            } else {
                list.add(prev);
                prev = interval;
            }
        }

        list.add(prev);
        return list.toArray(new int[list.size()][]);
    }
}