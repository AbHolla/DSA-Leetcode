/**
 * @param {string} s
 * @return {boolean}
 */
var hasSameDigits = function(s) {
    let n=s.length;

    let arr=Array.from(s,ch=>ch.charCodeAt(0)-48);
    while(arr.length>2){
        let next=new Array(arr.length-1);
        for(let i=0;i<arr.length-1;i++){
            next[i]=(arr[i]+arr[i+1])%10;
        }
        arr=next;
    }
    return arr[0]==arr[1];
};