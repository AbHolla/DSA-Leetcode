/**
 * @param {number[][]} intervals
 * @return {number}
 */
var eraseOverlapIntervals = function(arr) {
    arr.sort((a,b) => a[1]-b[1]);

    let removedCount=0;
    let k=-Infinity;

    for(let i=0;i<arr.length;i++){
        if(arr[i][0]<k){
            ++removedCount;
        }else{
            k=arr[i][1];
        }
    }
    return removedCount;
};