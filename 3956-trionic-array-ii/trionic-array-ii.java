class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        long inc = Long.MIN_VALUE;   
        long dec = Long.MIN_VALUE;   
        long inc2 = Long.MIN_VALUE;  

        long ans = Long.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            long newInc = Long.MIN_VALUE;
            long newDec = Long.MIN_VALUE;
            long newInc2 = Long.MIN_VALUE;

            if (nums[i] > nums[i - 1]) {
                if (inc != Long.MIN_VALUE)
                    newInc = inc + nums[i];
                newInc = Math.max(newInc, (long) nums[i - 1] + nums[i]);

                if (dec != Long.MIN_VALUE)
                    newInc2 = dec + nums[i];
                if (inc2 != Long.MIN_VALUE)
                    newInc2 = Math.max(newInc2, inc2 + nums[i]);
            }

            if (nums[i] < nums[i - 1]) {
    
                if (inc != Long.MIN_VALUE)
                    newDec = inc + nums[i];
                if (dec != Long.MIN_VALUE)
                    newDec = Math.max(newDec, dec + nums[i]);
            }

            inc = newInc;
            dec = newDec;
            inc2 = newInc2;

            if (inc2 != Long.MIN_VALUE)
                ans = Math.max(ans, inc2);
        }

        return ans;
    }
}
