class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Edge cases
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Case 1: Rob houses from index 0 to n-2
        int case1 = robLinear(nums, 0, n - 2);

        // Case 2: Rob houses from index 1 to n-1
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
