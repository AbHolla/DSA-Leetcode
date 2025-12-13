/**
 * @param {string[]} code
 * @param {string[]} businessLine
 * @param {boolean[]} isActive
 * @return {string[]}
 */
var validateCoupons = function (code, businessLine, isActive) {

    const priority = {
        "electronics": 0,
        "grocery": 1,
        "pharmacy": 2,
        "restaurant": 3
    };

    const validCoupons = [];

    for (let i = 0; i < code.length; i++) {

        // Must be active
        if (!isActive[i]) continue;

        // Business line must be valid
        if (!(businessLine[i] in priority)) continue;

        // Code must be non-empty and valid
        if (!code[i] || !/^[a-zA-Z0-9_]+$/.test(code[i])) continue;

        validCoupons.push([businessLine[i], code[i]]);
    }

    // Sort by businessLine priority, then ASCII lexicographical code
    validCoupons.sort((a, b) => {
        if (priority[a[0]] !== priority[b[0]]) {
            return priority[a[0]] - priority[b[0]];
        }

        // Strict ASCII comparison (NOT localeCompare)
        if (a[1] < b[1]) return -1;
        if (a[1] > b[1]) return 1;
        return 0;
    });

    // Return only coupon codes
    return validCoupons.map(c => c[1]);
};