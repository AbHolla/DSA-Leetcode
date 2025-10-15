/**
 * @param {number[]} nums
 * @return {number}
 */
var maxIncreasingSubarrays = function(nums) {
    const n = nums.length;
    const left = Array(n).fill(1);
    const right = Array(n).fill(1);

    // Step 1: Length of increasing sequence ending at i
    for (let i = 1; i < n; i++) {
        if (nums[i] > nums[i - 1])
            left[i] = left[i - 1] + 1;
    }

    // Step 2: Length of increasing sequence starting at i
    for (let i = n - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1])
            right[i] = right[i + 1] + 1;
    }

    // Step 3: Find max possible k
    let maxK = 0;
    for (let i = 0; i < n - 1; i++) {
        const possibleK = Math.min(left[i], right[i + 1]);
        maxK = Math.max(maxK, possibleK);
    }

    return maxK;
};
