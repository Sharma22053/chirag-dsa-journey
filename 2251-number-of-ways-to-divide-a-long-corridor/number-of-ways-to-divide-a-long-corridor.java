class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfWays(String corridor) {
        long ways = 1;
        int seatCount = 0;
        int plants = 0;
        boolean counting = false;

        for (char ch : corridor.toCharArray()) {
            if (ch == 'S') {
                seatCount++;

                if (seatCount > 2 && seatCount % 2 == 1) {
                    ways = (ways * (plants + 1)) % MOD;
                    plants = 0;
                }
                counting = seatCount % 2 == 0;
            } else if (counting) {
                plants++;
            }
        }

        return seatCount > 0 && seatCount % 2 == 0 ? (int) ways : 0;
    }
}
