class Solution {
    public int totalMoney(int n) {
        int remainder = n / 7;
        int first = 28;
        int last = 28 + (remainder - 1) * 7;
        int sum = remainder * (first + last) / 2;

        int monday = 1 + remainder;
        int finalWeek = 0;
        for (int i = 0; i < n % 7; i++) {
            finalWeek += monday + i;
        }
        return sum + finalWeek;
    }
}