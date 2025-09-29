/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    s.sort((a,b) =>(a-b));
    g.sort((a,b) =>(a-b));

    let i=0;
    let j=0;
    while(j<s.length){
        if(s[j]>=g[i]){
            i++;
        }
        j++;
    }
    return i;

};