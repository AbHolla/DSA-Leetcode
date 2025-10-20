/**
 * @param {number} n
 * @return {number}
 */
let dp={};
var climbStairs = function(n) {
    if(n<=2){
        return n;
    }
    if(!dp[n]){
        dp[n]=climbStairs(n-1)+climbStairs(n-2);
    }
    return dp[n];
};