class Solution {
    public int[] plusOne(int[] digit) {
        for(int i=digit.length-1;i>=0;i--){
            if(digit[i]<9){
                digit[i]++;
                return digit;
            }
            digit[i]=0;
        }
        int[] arr=new int[digit.length+1];
        arr[0]=1;
        return arr;
    }
}