/**
 * @param {number[]} nums
 * @return {boolean[]}
 */
var prefixesDivBy5 = function(nums) {
    const ans = new Array(nums.length);
    let valueMod5 = 0;

    for (let i = 0; i < nums.length; i++) {
        valueMod5 = (valueMod5 * 2 + nums[i]) % 5;
        ans[i] = (valueMod5 === 0);
    }
    return ans;
};