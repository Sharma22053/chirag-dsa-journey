class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long total = 0, turns = 0;
        int i = n-1;
        while(k > 0 ){
            total += Math.max(happiness[i] - turns, 0);
             turns++;
             i--;
             k--;
        }
        return total;
    }
}