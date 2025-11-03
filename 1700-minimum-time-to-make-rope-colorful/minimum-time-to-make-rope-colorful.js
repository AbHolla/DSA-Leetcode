/**
 * @param {string} colors
 * @param {number[]} neededTime
 * @return {number}
 */
var minCost = function(colors, neededTime) {
    let ans=0
    let n=colors.length;

    for(let i=0;i<n;i++){
        let maxTime=neededTime[i];
        let sum=neededTime[i];
        let j=i+1;

        while(j<n && colors[i]==colors[j]){
            sum+=neededTime[j];
            maxTime=Math.max(maxTime,neededTime[j]);
            j++;
        }
        ans+=sum-maxTime;
        i=j-1;
    }

    return ans;
};