class Solution {
    public long maximumHappinessSum(int[] h, int k) {
        Arrays.sort(h);

        long sum=0;
        int turns=0;

        for(int i= h.length-1 ; i>=0 && turns <k; i--) {
            int effective=h[i]-turns;
            if(effective <=0)break;
            sum+=effective;
            turns++;
        }
        return sum;
    }
}