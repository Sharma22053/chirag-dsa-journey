class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
       if(hand.length % groupSize != 0) return false;
       HashMap<Integer,Integer> hmap = new HashMap<>();
       for(int i: hand){
        hmap.put(i,hmap.getOrDefault(i,0)+1);
       }

       PriorityQueue<Integer> pq = new PriorityQueue<>(hmap.keySet());

       while(!pq.isEmpty()){
        int first = pq.peek();

        while(!pq.isEmpty() && hmap.getOrDefault(pq.peek() , 0) == 0){
            pq.poll();
        }

        if(pq.isEmpty()) break;
        first = pq.peek();
        for(int i= first;i<first+groupSize;i++){
            if(!hmap.containsKey(i) || hmap.get(i) == 0) return false;
            hmap.put(i,hmap.get(i) -1);
        }
       }

       return true;
    }
}