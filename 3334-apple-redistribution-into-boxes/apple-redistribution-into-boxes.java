class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = Arrays.stream(apple).sum();
        int count = 0;
        for(int i = capacity.length -1 ; i>=0;i--){
            if(sum <= 0) break;
            sum -= capacity[i];
            count++;
        }
        return count;
    }
}