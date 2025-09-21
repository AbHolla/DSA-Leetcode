/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    let result=[];
    nums.sort((a,b)=>(a-b));
    let backtrack=(path,start)=>{
        result.push([...path]);
        for(let i=start;i<nums.length;i++){
            if(i>start && nums[i-1]===nums[i])
                continue;

            path.push(nums[i]);
            backtrack(path,i+1);
            path.pop();
            
        }

    }
    backtrack([],0);
    return result;

};