class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long result = 1;
        int previous = 1;
        for(int i=1;i<n;i++){
            if(prices[i] == prices[i-1] -1){
                previous++;
            }else{
                previous = 1;
            }
            result += previous;
        }
        return result;
    }
   }