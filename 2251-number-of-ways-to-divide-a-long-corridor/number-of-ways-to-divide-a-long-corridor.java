class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfWays(String corridor) {
        int n = corridor.length();
        int[] seatPos = new int[n];
        int seatCount = 0;

        // Store seat positions
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                seatPos[seatCount++] = i;
            }
        }

        // Invalid cases
        if (seatCount == 0 || seatCount % 2 != 0) {
            return 0;
        }

        long ways = 1;

        // Process sections
        for (int i = 2; i < seatCount; i += 2) {
            int prevSecondSeat = seatPos[i - 1];
            int nextFirstSeat = seatPos[i];

            int plantsBetween = nextFirstSeat - prevSecondSeat - 1;
            ways = (ways * (plantsBetween + 1)) % MOD;
        }

        return (int) ways;
    }
}