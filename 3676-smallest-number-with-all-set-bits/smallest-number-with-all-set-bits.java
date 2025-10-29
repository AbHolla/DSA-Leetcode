class Solution {
    public int smallestNumber(int n) {
        if(n<=1){
            return 1;
        }
        int ones=1;
        while(ones<n){
            ones=(ones<<1)|1;
        }
        return ones;
    }
}