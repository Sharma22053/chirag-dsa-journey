class Solution {
    public int binaryGap(int n) {
        int[] temp = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i) 
            if (((n >> i) & 1) != 0) 
                temp[t++] = i;
            
        
        int ans = 0;
        for (int i = 0; i < t - 1; ++i) {
            ans = Math.max(ans, temp[i + 1] - temp[i]);
        }
        return ans;
    }
}