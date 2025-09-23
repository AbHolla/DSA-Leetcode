/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    let result=[];

    let backtrack=(path,remString)=>{

        if(!remString.length){
            result.push([...path]);
        
        }

        for(let i=1;i<=remString.length;i++){
            let choice=remString.substring(0,i);

            if(!isPalindrome(choice)) continue;

            path.push(choice);
            backtrack(path,remString.substring(i));
            path.pop();
        }

    }
    backtrack([],s);
    return result;
};

let isPalindrome = (s)=>{
    let i=0;
    let j=s.length-1;

    while(i<j){
        if(s[i++]!=s[j--])
            return false;
            
    }
    return true;    
}