class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 1;  // first day
        long len = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                len++;
            } else {
                len = 1;
            }
            result += len;
        }

        return result;
    }
}