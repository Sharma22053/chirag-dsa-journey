class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] result = new int[nums.length];
        for(int i : nums){
            pq.add(i);
        }
        int j = 0;
        while(!pq.isEmpty()){
            int alice = pq.poll();
            int bob =pq.poll();
           
            result[j] = bob;
            result[j+1] = alice;
            j = j+2;
        }

        return result;
    }
}