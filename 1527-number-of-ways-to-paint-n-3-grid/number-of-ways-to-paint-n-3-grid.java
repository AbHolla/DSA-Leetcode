class Solution {
    public int numOfWays(int n) {
        
        final int MOD = 1_000_000_007;

        
        long same = 6; // ABA patterns
        long diff = 6; // ABC patterns

        
        for (int i = 2; i <= n; i++) {

            
            long prevSame = same;
            long prevDiff = diff;

            
            same = (prevSame * 3 + prevDiff * 2) % MOD;
            diff = (prevSame * 2 + prevDiff * 2) % MOD;
        }

        
        return (int) ((same + diff) % MOD);
    }
}
