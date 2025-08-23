class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (char c : tasks) {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(hmap.values());
        Queue<int[]> coolDown = new LinkedList<>();
        int time =0;

        while(!maxHeap.isEmpty() || !coolDown.isEmpty()){
            time++;
            if(!coolDown.isEmpty() && coolDown.peek()[0] == time){
                maxHeap.offer(coolDown.poll()[1]);
            }

            if(!maxHeap.isEmpty()){
                int freq = maxHeap.poll();
                int remainingFreq = freq -1;
                if(remainingFreq > 0){
                    int next = time + n+1;
                    coolDown.add(new int[] {next,remainingFreq});
                }
            }
        }
        return time;
    }
}