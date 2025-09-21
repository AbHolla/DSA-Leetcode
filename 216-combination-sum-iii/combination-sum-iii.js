/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {
    let result=[];
    let backtrack=(rSum,path,start)=>{
        if(path.length==k){
            if(rSum==0){
                result.push([...path]);
            }
            return;
        }

        for(let i=start;i<=9;i++){
            path.push(i);
            backtrack(rSum-i,path,i+1);
            path.pop();
        }

    }
    backtrack(n,[],1);
    return result;
};