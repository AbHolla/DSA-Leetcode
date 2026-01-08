class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int product = nums1[i - 1] * nums2[j - 1];

                // Option 1: take both elements
                // Either start new or extend previous subsequence
                int takeBoth = product;
                if (dp[i - 1][j - 1] > 0) {
                    takeBoth += dp[i - 1][j - 1];
                }

                // Option 2: skip nums1[i-1]
                int skipNums1 = dp[i - 1][j];

                // Option 3: skip nums2[j-1]
                int skipNums2 = dp[i][j - 1];

                // Take maximum of all options
                dp[i][j] = Math.max(takeBoth, Math.max(skipNums1, skipNums2));
            }
        }

        return dp[n][m];
    }
}
