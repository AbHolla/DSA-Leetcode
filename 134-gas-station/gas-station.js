/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {
    let currgain=0;
    let totalGain=0;

    let ans=0;

    for(let i=0;i<gas.length;i++){
        let gain=gas[i]-cost[i];
        currgain=currgain+gain;
        totalGain=totalGain+gain;
        if(currgain<0){
            ans=i+1;
            currgain=0;
        }
    }
    return totalGain >=0 ? ans : -1;
};