/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxDistinctElements = function(nums, k) {
    nums.sort((a, b) => a - b);

    let nextAvailable = -Infinity;
    let count = 0;

    for (let num of nums) {
        // The smallest we can assign to this element
        let start = num - k;
        let end = num + k;

        // Make sure we don’t reuse a smaller number
        let val = Math.max(start, nextAvailable);

        // If the chosen value is still within range
        if (val <= end) {
            count++;
            nextAvailable = val + 1; // move pointer forward
        }
    }
    return count;
};