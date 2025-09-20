/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    let result=[];

    let backtrack=(path,start)=>{
        if(path.length==k){
            result.push([...path]);
            return;
        }
        for(let i=start;i<=n;i++){
            path.push(i);
            backtrack(path,i+1);
            path.pop();
        }

    }
    backtrack([],1);
    return result;
};