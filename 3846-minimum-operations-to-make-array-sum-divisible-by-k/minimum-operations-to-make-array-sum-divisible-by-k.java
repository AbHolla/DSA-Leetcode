class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int rem = sum % k;
        return rem; // 0 if divisible, else rem
    }
}
