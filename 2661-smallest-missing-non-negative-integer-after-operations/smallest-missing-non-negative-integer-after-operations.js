/**
 * @param {number[]} nums
 * @param {number} value
 * @return {number}
 */
var findSmallestInteger = function(nums, value) {
    const count = new Array(value).fill(0);

    for (let num of nums) {
        let rem = ((num % value) + value) % value;
        count[rem]++;
    }

    let mex = 0;
    while (true) {
        let rem = mex % value;
        if (count[rem] === 0) break;
        count[rem]--;
        mex++;
    }

    return mex;
};