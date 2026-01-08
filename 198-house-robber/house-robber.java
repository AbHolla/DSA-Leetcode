class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];

        // int p1=Math.max(nums[0],nums[1]);
        // int p2=nums[0];

        // for(int i=2;i<n;i++){
        //     int curr=Math.max(nums[i]+p2, p1);
        //     int temp=p1;
        //     p2=p1;
        //     p1=curr;
        //     curr++;
        // }
        // return p1;

        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}