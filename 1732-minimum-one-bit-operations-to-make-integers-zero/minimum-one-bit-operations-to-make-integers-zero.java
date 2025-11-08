class Solution {
    public int minimumOneBitOperations(int n) {
        if(n == 0) return 0;
        long[] ops = new long[32];
        ops[0] = 1;
        for(int i=1;i<32;i++){
            ops[i] = (2 * ops[i-1]) + 1;
        }
        int result = 0;
        int sign = 1;
        for(int i= 31;i>=0;i--){
            if(( (1 << i) & n) == 0) continue;
            if(sign > 0) result += ops[i];
            else result -= ops[i];
            sign = sign * -1;
        }
        return result;
        
    }
}