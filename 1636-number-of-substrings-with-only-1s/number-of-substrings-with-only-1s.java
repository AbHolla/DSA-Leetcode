
class Solution {
    public int numSub(String s) {
        final int MOD = 1_000_000_007;
        long count = 0, result = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
                result = (result + count) % MOD;
            } else {
                count = 0;
            }
        }

        return (int) result;
    }
}