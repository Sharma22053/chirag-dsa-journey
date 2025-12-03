class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            inDegree[favorite[i]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        int[] depth = new int[n];
        Arrays.fill(depth, 1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int next = favorite[node];
            depth[next] = Math.max(depth[next], depth[node] + 1);
            if (--inDegree[next] == 0) {
                queue.offer(next);
            }
        }
        int longestCycle = 0;
        int twoCycle = 0;
        for (int person = 0; person < n; ++person) {
            if(inDegree[person] == 0) continue;
            int cycleLength = 0;
            int current = person;
            while(inDegree[current] != 0){
                inDegree[current] = 0;
                cycleLength++;
                current=favorite[current];
            }
            if(cycleLength == 2){
                twoCycle += depth[person]+depth[favorite[person]];
            }else {
                longestCycle = Math.max(longestCycle,cycleLength);
            }
        }
        return Math.max(twoCycle,longestCycle);
    }
}