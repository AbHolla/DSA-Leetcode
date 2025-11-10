/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function(nums) {
    const stack = [];
    let ans = 0;

    for (const v of nums) {
        if (v === 0) {
            // zero splits segments: active values can't cross this point
            stack.length = 0;   // clear stack
            continue;
        }

        // remove values strictly greater than current
        while (stack.length && stack[stack.length - 1] > v) {
            stack.pop();
        }

        // if top equals current, no new operation needed
        if (stack.length && stack[stack.length - 1] === v) {
            continue;
        }

        // otherwise we need a new operation grouped for this value
        stack.push(v);
        ans++;
    }

    return ans;
};