/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var hasIncreasingSubarrays = function(nums, k) {
    const n = nums.length;
    const inc = Array(n).fill(1);

    for (let i = 1; i < n; i++) {
        if (nums[i] > nums[i - 1]) {
            inc[i] = inc[i - 1] + 1;
        }
    }

    for (let a = 0; a + 2 * k <= n; a++) {
        const firstEnd = a + k - 1;
        const secondEnd = a + 2 * k - 1;

        if (inc[firstEnd] >= k && inc[secondEnd] >= k) {
            return true;
        }
    }

    return false;
};
