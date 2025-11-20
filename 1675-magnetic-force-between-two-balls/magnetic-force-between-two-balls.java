class Solution {
    public int maxDistance(int[] position, int m) {
        int answer = 0;
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = (int)Math.ceil(position[n-1]/(m-1.0));
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canPlace(mid,position,m)){
                answer = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return answer;
    }
    private boolean canPlace(int x,int[] position,int m){
        int previous = position[0];
        int ballsPlaced = 1;

        for(int i=1;i<position.length && ballsPlaced < m;i++){
            int current = position[i];
            if(current - previous >= x){
                ballsPlaced += 1;
                previous = current;
            }
        }
        return ballsPlaced == m;
    }
}