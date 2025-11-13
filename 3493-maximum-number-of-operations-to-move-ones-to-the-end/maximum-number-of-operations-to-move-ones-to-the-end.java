class Solution {
    public int maxOperations(String s) {
        int count=0,n=s.length(),curr=0;
        boolean inZeroBlock=false;
        for(int i=n-1;i>=0;i--){
            if(!inZeroBlock && s.charAt(i)=='0'){
                inZeroBlock=true;
                curr++;
            }
            if(inZeroBlock && s.charAt(i)=='1'){
                inZeroBlock=false;
            }
            if(s.charAt(i)=='1')
            count+=curr;
        }
        return count;
    }
}