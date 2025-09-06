/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function(s1, s2) {
    if (s1.length > s2.length) return false;
    let hashS = Array(26).fill(0);
    let hashW = Array(26).fill(0);
    let windowLength = s1.length;
    for (let i = 0; i < windowLength; i++) {
        hashS[s1.charCodeAt(i) - 97]++;
        hashW[s2.charCodeAt(i) - 97]++;
    }
    let i = 0;
    let j = windowLength - 1;

    while (j < s2.length) {
        if (isHashSame(hashS, hashW)) {
            return true;
        }
        hashW[s2.charCodeAt(i) - 97]--;
        i++;
        j++;
        if (j < s2.length) {
            hashW[s2.charCodeAt(j) - 97]++;
        }
    }
    return false;
};
var isHashSame = function(hashS, hashW) {
    for (let i = 0; i < 26; i++) {
        if (hashS[i] !== hashW[i]) {
            return false;
        }
    }
    return true;
};