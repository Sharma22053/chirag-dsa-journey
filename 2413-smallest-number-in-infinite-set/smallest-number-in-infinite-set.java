class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    Set<Integer> set;
    int current;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        current = 1;
    }
    
    public int popSmallest() {
        if(!pq.isEmpty()){
            int val = pq.poll();
            set.remove(val);
            return val;

        } 
        return current++; 
    }
    
    public void addBack(int num) {
       if(num < current && !set.contains(num)){
        pq.add(num);
        set.add(num);
       }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */