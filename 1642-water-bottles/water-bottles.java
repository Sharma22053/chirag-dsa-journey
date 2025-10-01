class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        while(numBottles >= numExchange){
            int k = numBottles / numExchange;
            count += numExchange * k;
            numBottles -= numExchange * k;
            numBottles += k;
        }

        return count + numBottles;
    }
}