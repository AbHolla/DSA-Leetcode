/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
    // if(n==0){
    //     return 0;
    // }
    // if(n<=1){
    //     return n;
    // }
    // return fib(n-1)+fib(n-2);


    let dp=[0,1];
    for(let i=2;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
    }
    return dp[n];
};