/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
var leastInterval = function(arr, n) {
    let freq=Array(26).fill(0);
    let maxfreq=0;

    for(let i=0;i<arr.length;i++){
        let curr=arr[i].charCodeAt()-65;
        ++freq[curr];
        maxfreq=Math.max(maxfreq,freq[curr]);
    }
    let noOfMaxFreqcount =0;
    for(let i=0;i<arr.length;i++){
        if(freq[i]==maxfreq){
            ++noOfMaxFreqcount;
        }
    }

    let cycle=((n+1) *(maxfreq-1))+ noOfMaxFreqcount;

    return Math.max(cycle,arr.length);
};