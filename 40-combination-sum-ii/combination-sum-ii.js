/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(arr, target) {
    let result=[];
    arr.sort((a,b)=>(a-b));
    let backtrack=(rSum,path,start)=>{
        if(rSum==0) result.push([...path]);
        if(rSum<=0) return;
        for(let i=start;i<arr.length;i++){
            if(i>start && arr[i-1]===arr[i])
                continue;

            path.push(arr[i]);
            backtrack(rSum-arr[i],path,i+1);
            path.pop();
            
            
        }
    }
    backtrack(target,[],0);
    return result;
};