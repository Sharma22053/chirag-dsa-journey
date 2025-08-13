class Solution {
    public boolean isPowerOfThree(int n) {
        int max = (int)Math.pow(3,19);
        return n > 0 && max % n == 0;
    }
}