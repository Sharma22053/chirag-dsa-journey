class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> hmap = new HashMap<>();
        final int mod = 1000000007;
        long answer = 0;
        long sum = 0;
        for (int[] edge : points) {
            hmap.put(edge[1], hmap.getOrDefault(edge[1], 0) + 1);

        }
        for (int num : hmap.values()) {
            long ed = ((long) num * (num - 1)) / 2;
            answer = (answer + ed * sum) % mod;
            sum = (sum + ed) % mod;
        }
        return (int) answer;
    }
}