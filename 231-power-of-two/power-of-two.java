class Solution {
    public boolean isPowerOfTwo(int n) {
        int max = (int)Math.pow(2,30);
        return n > 0 && max % n == 0;
    }
}