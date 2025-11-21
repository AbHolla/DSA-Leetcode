/**
 * @param {string} s
 * @return {number}
 */
var countPalindromicSubsequence = function(s) {
    let n = s.length;
    let first = Array(26).fill(-1);
    let last = Array(26).fill(-1);

    // Record first and last occurrence of each letter
    for (let i = 0; i < n; i++) {
        let c = s.charCodeAt(i) - 97;
        if (first[c] === -1) first[c] = i;
        last[c] = i;
    }

    let result = 0;

    // For each character as left & right boundary
    for (let c = 0; c < 26; c++) {
        if (first[c] !== -1 && last[c] > first[c]) {

            let set = new Set();
            for (let i = first[c] + 1; i < last[c]; i++) {
                set.add(s[i]);
            }
            result += set.size;
        }
    }

    return result;
};