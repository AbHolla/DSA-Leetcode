import java.util.*;

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int maxLen = 1;
        int r = 0;

        for (int l = 0; l < n; l++) {
            while (r < n && (long) nums[r] <= (long) nums[l] * k) {
                r++;
            }
            maxLen = Math.max(maxLen, r - l);
        }

        return n - maxLen;
    }
}
