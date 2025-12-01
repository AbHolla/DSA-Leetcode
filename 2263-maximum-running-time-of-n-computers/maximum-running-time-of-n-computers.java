class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n;  // max possible time per computer

        while (left < right) {
            long mid = right - (right - left) / 2; // upper mid

            if (canRun(mid, batteries, n))
                left = mid;
            else
                right = mid - 1;
        }

        return left;
    }

    private boolean canRun(long t, int[] batteries, int n) {
        long total = 0;
        for (int b : batteries) {
            total += Math.min(b, t);
        }
        return total >= t * n;
    }
}