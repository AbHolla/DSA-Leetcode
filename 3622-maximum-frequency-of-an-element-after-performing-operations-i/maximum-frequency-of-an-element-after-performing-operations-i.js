/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} numOperations
 * @return {number}
 */
var maxFrequency = function(nums, k, numOperations) {
    if (!nums || nums.length === 0) return 0;

    const n = nums.length;
    let maxVal = 0;
    for (const v of nums) if (v > maxVal) maxVal = v;

    const freq = new Array(maxVal + 1).fill(0);
    for (const v of nums) freq[v]++;

    const pref = new Array(maxVal + 1).fill(0);
    pref[0] = freq[0];
    for (let i = 1; i <= maxVal; i++) pref[i] = pref[i - 1] + freq[i];

    let best = 0;
    for (let t = 0; t <= maxVal; t++) {
        const left = Math.max(0, t - k);
        const right = Math.min(maxVal, t + k);
        const totalInRange = pref[right] - (left > 0 ? pref[left - 1] : 0);
        const otherInRange = totalInRange - freq[t];
        const canChange = Math.min(numOperations, otherInRange);
        const frequency = freq[t] + canChange;
        if (frequency > best) best = frequency;
    }
    return best;
}