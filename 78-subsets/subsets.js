/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let result=[];
    let backtrack=(path,start)=>{
        result.push([...path]);
        for(let i=start;i<nums.length;i++){
            path.push(nums[i]);
            backtrack(path,i+1);
            path.pop();
        }
    }
    backtrack([],0);
    return result;
};