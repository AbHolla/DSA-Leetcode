/**
 * @param {number} n
 * @return {number[]}
 */
var getNoZeroIntegers = function(n) {
     for (let a = 1; a < n; a++) {
        let b = n - a;
        if (isNoZero(a) && isNoZero(b)) {
            return [a, b];
        }
    }
}

function isNoZero(num) {
    return !num.toString().includes('0');
}