class Solution {
    public int minBitFlips(int start, int goal) {
        if(start == goal) return 0;
        int count = 0;
        for(int i= 0;i<32;i++){
            int startBit = start & (1<<i);
            int goalBit = goal & (1<<i);
            if(startBit != goalBit){
                start = start ^ (1<<i);
                count++;
            }
        }
        return count;
    }
}