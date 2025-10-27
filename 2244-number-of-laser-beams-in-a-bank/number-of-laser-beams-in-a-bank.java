class Solution {
    public int numberOfBeams(String[] bank) {
        int previous = 0;
        int answer = 0;
        for(int i=0;i<bank.length;i++){
            int count = 0;
            for(char ch : bank[i].toCharArray()){
                if(ch - '0' == 1){
                    count++;
                }
            }
            if(count != 0){
                answer += count * previous;
                previous = count;
            }
        }
        return answer;

    }
}