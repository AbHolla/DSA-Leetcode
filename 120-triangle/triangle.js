/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
    let n=triangle.length;

    for(let row=n-2;row>=0;row--){
        for(let col=0;col<=row;col++){
            triangle[row][col]+=Math.min(triangle[row+1][col],triangle[row+1][col+1]);
        }
    }
    return triangle[0][0];
};