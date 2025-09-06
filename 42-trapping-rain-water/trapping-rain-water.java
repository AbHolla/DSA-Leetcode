class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int[] maxL=new int[n];
        maxL[0]=arr[0];
        for(int i=1;i<n;i++){
            maxL[i]=Math.max(maxL[i-1],arr[i]);
        }

        int[] maxR=new int[n];
        maxR[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            maxR[i]=Math.max(arr[i],maxR[i+1]);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            int watertrapped=Math.min(maxL[i],maxR[i])-arr[i];
            ans+=Math.max(watertrapped,0);
        }
        
        return ans;
    }
}