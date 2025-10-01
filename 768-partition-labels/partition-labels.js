/**
 * @param {string} s
 * @return {number[]}
 */
var partitionLabels = function(s) {
    let ans=[];
    let first=Array(26).fill(-1);
    let last=Array(26).fill(-1);

    for(let i=0;i<s.length;i++){
        let curr=s.charCodeAt(i)-97;
        if(first[curr]<0){
            first[curr]=i;
        }
        last[curr]=i;
    }

    let pStart=0;
    let pEnd=0;

    for(let i=0;i<s.length;i++){
        let curr=s.charCodeAt(i)-97;

        if(pEnd<first[curr]){
            ans.push(pEnd-pStart+1);
            pStart=pEnd=i;
        }

        pEnd=Math.max(pEnd,last[curr]);
    }

    if(pEnd-pStart+1 >0){
        ans.push(pEnd-pStart+1);
    }

    return ans;
};