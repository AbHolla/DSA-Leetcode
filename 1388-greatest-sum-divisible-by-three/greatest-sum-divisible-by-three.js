/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSumDivThree = function(nums) {
    let sum = 0;

    let min1 = Infinity, sec1 = Infinity;
    let min2 = Infinity, sec2 = Infinity;

    for (let num of nums) {
        sum += num;

        if (num % 3 === 1) {
            if (num < min1) {
                sec1 = min1;
                min1 = num;
            } else if (num < sec1) {
                sec1 = num;
            }
        } else if (num % 3 === 2) {
            if (num < min2) {
                sec2 = min2;
                min2 = num;
            } else if (num < sec2) {
                sec2 = num;
            }
        }
    }

    if (sum % 3 === 0) return sum;

    let result = 0;

    if (sum % 3 === 1) {
        let option1 = min1 !== Infinity ? sum - min1 : -Infinity;
        let option2 = (min2 !== Infinity && sec2 !== Infinity) ? sum - min2 - sec2 : -Infinity;
        result = Math.max(option1, option2);
    } else {
        let option1 = min2 !== Infinity ? sum - min2 : -Infinity;
        let option2 = (min1 !== Infinity && sec1 !== Infinity) ? sum - min1 - sec1 : -Infinity;
        result = Math.max(option1, option2);
    }

    return result < 0 ? 0 : result;
};