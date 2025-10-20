/**
 * @param {string[]} operations
 * @return {number}
 */
var finalValueAfterOperations = function(operations) {
    let X=0;
    for(let op of operations){
        if(op.includes('+')){
            X++;
        }else{
            X--;
        }
    }
    return X;

};