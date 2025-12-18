class Solution {
    public long minMoves(int[] balance) {
        long sum = 0;
        int n = balance.length;
        int index = -1;
        for(int i=0;i<n;i++){
            sum += balance[i];
            if(balance[i] < 0) index = i;
        }

        if(sum < 0) return -1;
        if(index == -1) return 0;
        long value = balance[index];
        int left = (index -1 + n)%n;
        int right = (index+1)%n;
        long distance = 1;
        long answer = 0;
        while(value < 0){
            if(balance[left] > 0){
                long temp1 = Math.min(balance[left] , -value);
                value += temp1;
                answer += (distance * temp1);
            }
            if(value < 0 && balance[right] > 0){
                long temp2 = Math.min(balance[right] , -value);
                value += temp2;
                answer += (distance * temp2);
            }

            left = (left - 1 + n) % n;
            right = (right + 1)%n;
            distance++;
        }
        return answer;

    }
}