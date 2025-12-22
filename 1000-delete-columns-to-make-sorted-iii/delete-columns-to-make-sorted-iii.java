class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int[] dp = new int[m];
        int maxKept = 1;

        for (int j = 0; j < m; j++) {
            dp[j] = 1; // keep only this column
            for (int i = 0; i < j; i++) {
                if (canExtend(strs, i, j)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            maxKept = Math.max(maxKept, dp[j]);
        }

        return m - maxKept;
    }

    private boolean canExtend(String[] strs, int i, int j) {
        for (String s : strs) {
            if (s.charAt(i) > s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
