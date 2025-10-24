/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
// let dp={};
//     if(n<=2){
//         return n;
//     }
//     if(!dp[n]){
//         dp[n]=climbStairs(n-1)+climbStairs(n-2);
//     }
//     return dp[n];

    let dp=[0,1,2];
    for(let i=3;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
    }
    return dp[n];

};