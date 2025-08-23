class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (char c : tasks) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(hmap.values());
        int time = 0;

        while(!pq.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int task =0;
            int cycle = n+1;

            while(cycle-- >0 && !pq.isEmpty()){
                int curr = pq.poll();
                if(curr > 1){
                    list.add(curr - 1);
                }
                task++;
            }

            for(int i : list){
                pq.add(i);
            }

            time += pq.isEmpty() ? task : n+1;
        }

        return time;
    }
}