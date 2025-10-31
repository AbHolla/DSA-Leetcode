/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getSneakyNumbers = function(nums) {
    let seen= new Set();
    let dup=[];

    for(let num of nums){
        if(seen.has(num)){
            dup.push(num);
            if(dup.length==2) break;
        }
        else{
            seen.add(num);
        }
    }
    return dup;

};