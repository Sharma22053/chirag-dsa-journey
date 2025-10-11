class Solution {
    Map<Integer, Long> hmap = new HashMap<>();
    List<Integer> keys;
    long[] dp;

    public long maximumTotalDamage(int[] power) {
        for (int i : power) {
            hmap.put(i, hmap.getOrDefault(i, 0L) + 1);
        }
        keys = new ArrayList<>(hmap.keySet());
        Collections.sort(keys);
        int n = keys.size();
        dp = new long[n];
        Arrays.fill(dp,-1);
        return dfs(n-1);

    }
    private long dfs(int index){
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];

        long leave = dfs(index-1);

        long take = hmap.get(keys.get(index)) * keys.get(index);
        int previous = binarySearch(keys,index-1,keys.get(index) - 3);

        if(previous >= 0) take += dfs(previous);

        return dp[index] = Math.max(take,leave);

    }

    private int binarySearch(List<Integer> keys,int index,int value){
        int left = 0, right = index,answer = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(keys.get(mid) <= value){
                answer = mid;
                left = mid +1;
            } else{
                right = mid-1;
            }
        }
        return answer;
    }
}