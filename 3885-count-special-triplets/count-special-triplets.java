class Solution {
    public int specialTriplets(int[] nums) {
        
        final int mod = 1_000_000_007;
       
        Map<Integer, Long> right = new HashMap<>();
        Map<Integer, Long> left = new HashMap<>();

        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }
        long ans = 0;
        for (int x : nums) {
            right.put(x, right.get(x) - 1);

            long target = (long) x * 2L;

            long leftCount = left.getOrDefault((int) target, 0L);
            long rightCount = right.getOrDefault((int) target, 0L);

            long add = (rightCount * leftCount) % mod;
            ans = (ans + add) % mod;
            left.put(x, left.getOrDefault(x, 0L) + 1);
        }
        return (int) (ans % mod);

    }
}