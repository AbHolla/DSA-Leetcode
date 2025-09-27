/**
 * @param {number[][]} costs
 * @return {number}
 */
var twoCitySchedCost = function(costs) {
    let ans=0;
    costs.sort((a,b) => (b[1]-b[0])-(a[1]-a[0]));
    let n=costs.length/2;

    for(let i=0;i<n;i++){
        ans+=costs[i][0];
    }
    for(let i=n;i<2*n;i++){
        ans+=costs[i][1];
    }

    return ans;
};