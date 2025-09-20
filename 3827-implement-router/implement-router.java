class Router {
    int size;
    Map<Integer,List<Integer>> counts;
    Map<Long,int[]> packets;
    Queue<Long> queue;

    public Router(int memoryLimit) {
        this.size = memoryLimit;
        this.packets = new HashMap<>();
        this.counts = new HashMap<>();
        this.queue = new LinkedList<>();
    }
    private long encode(int source,int destination,int timestamp){
        return ((long) source<< 40) | ((long) destination << 20) | timestamp;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        long key = encode(source,destination,timestamp);
        if(packets.containsKey(key)) return false;
        if(packets.size() >= size) forwardPacket();

        packets.put(key,new int[] {source,destination,timestamp});
        queue.offer(key);

        counts.putIfAbsent(destination, new ArrayList<>());
        List<Integer> list = counts.get(destination);
        int idx = Collections.binarySearch(list, timestamp);
        if (idx < 0) idx = -idx - 1;
        list.add(idx, timestamp);

        return true;
    }
    
    public int[] forwardPacket() {
        if(packets.isEmpty()) return new int[]{};

        long key = queue.poll();
        int[] packet = packets.remove(key);

        if(packet == null) return new int[]{};

        int destination = packet[1];
        int timestamp = packet[2];
        
        List<Integer> list = counts.get(destination);
        if (list != null) list.remove(Integer.valueOf(timestamp));

        return packet;
        
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = counts.get(destination);
        if(list == null || list.isEmpty()){
            return 0;
        }

        int left = lowerBound(list,startTime);
        int right = upperBound(list,endTime);

        return right-left;
    }

    private int lowerBound(List<Integer> list,int startTime){
        int low = 0 , high = list.size();
        while(low < high){
            int mid = low + (high - low)/2;
            if(list.get(mid) < startTime) low = mid+1;
            else high = mid;
        }
        return low;

    }
    private int upperBound(List<Integer> list,int endTime){
        int low = 0 , high = list.size();
        while(low < high){
            int mid = low + (high - low)/2;
            if(list.get(mid) <= endTime) low = mid+1;
            else high = mid;
        }
        return low;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */