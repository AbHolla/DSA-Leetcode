class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[100001];
            int evenDistinct = 0;
            int oddDistinct = 0;

            for (int j = i; j < n; j++) {
                int v = nums[j];

                if (!seen[v]) {
                    seen[v] = true;
                    if ((v & 1) == 0) evenDistinct++;
                    else oddDistinct++;
                }

                if (evenDistinct == oddDistinct) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
