/**
 * @param {number[]} nums
 * @return {number}
 */
var countValidSelections = function(nums) {
    const n = nums.length;
    const totalSum = nums.reduce((a, b) => a + b, 0);
    let valid = 0;

    const simulate = (start, dir) => {
        const arr = [...nums];
        let curr = start;
        let decrements = 0;

        while (curr >= 0 && curr < n) {
            if (arr[curr] === 0) {
                curr += dir;
            } else {
                arr[curr]--;
                decrements++;
                dir *= -1;
                curr += dir;
            }

            if (decrements > totalSum) return false;
        }

        if (decrements < totalSum) return false;
        return arr.every(v => v === 0);
    };

    for (let i = 0; i < n; i++) {
        if (nums[i] === 0) {
            if (simulate(i, -1)) valid++;
            if (simulate(i, 1)) valid++;
        }
    }

    return valid;
};