class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;

        // Step 1: if array GCD > 1, impossible
        int overallGCD = nums[0];
        for (int num : nums) {
            overallGCD = gcd(overallGCD, num);
        }
        if (overallGCD > 1) return -1;

        // Step 2: if any 1 exists
        int countOnes = 0;
        for (int num : nums) if (num == 1) countOnes++;
        if (countOnes > 0) return n - countOnes;

        // Step 3: find shortest subarray with gcd = 1
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentGCD = nums[i];
            for (int j = i + 1; j < n; j++) {
                currentGCD = gcd(currentGCD, nums[j]);
                if (currentGCD == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; // gcd cannot improve beyond 1
                }
            }
        }

        return (minLen - 1) + (n - 1);
    }
}