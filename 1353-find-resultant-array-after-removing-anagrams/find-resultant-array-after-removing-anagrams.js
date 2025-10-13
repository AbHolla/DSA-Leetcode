/**
 * @param {string[]} words
 * @return {string[]}
 */
var removeAnagrams = function(words) {
    let result=[];

    const isAnagram=(a,b)=>{
        if(a.length!==b.length) return false;
        return a.split('').sort().join('')===b.split('').sort().join('');
    }

    for(let word of words){
        if(result.length && isAnagram(result[result.length-1],word)){
            continue;
        }
        else{
            result.push(word);
        }

    }
    return result;
};