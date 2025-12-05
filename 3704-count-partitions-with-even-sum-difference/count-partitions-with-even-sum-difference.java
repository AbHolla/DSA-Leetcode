class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int x:nums){ 
            sum+=x;
        }
        return (sum%2==0) ? (n-1):0;
    }
}