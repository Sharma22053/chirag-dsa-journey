class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] result = new int[arr.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0] - b[0]);
        for(int i=0;i<arr.length;i++){
            pq.add(new int[]{arr[i],i});
        }
        
        int rank = 1;
        int prev = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int value = curr[0];
            int index = curr[1];
            if(value != prev){
                result[index] = rank;
                prev = value;
                rank++;
            } else {
                result[index] = rank-1;
            }
            
        }
        
        return result;
    }
}


