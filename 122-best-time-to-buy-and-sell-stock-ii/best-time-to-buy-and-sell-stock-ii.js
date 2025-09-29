/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let maxProfit=0;
    for(let i=1;i<prices.length;i++){
        let profit=prices[i]-prices[i-1];
        if(profit>0){
            maxProfit+=profit;
        }
    }
    return maxProfit;


};