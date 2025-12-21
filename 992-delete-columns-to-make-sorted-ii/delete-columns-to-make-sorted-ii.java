class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        
        // sorted[i] = whether strs[i] < strs[i+1] is already confirmed
        boolean[] sorted = new boolean[n - 1];
        int deletions = 0;

        // Traverse columns from left to right
        for (int col = 0; col < m; col++) {

            // Step 1: Check if keeping this column breaks order
            boolean bad = false;
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    bad = true;
                    break;
                }
            }

            // Step 2: If bad, delete this column
            if (bad) {
                deletions++;
                continue;
            }

            // Step 3: Update sorted status
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                    sorted[i] = true;
                }
            }
        }

        return deletions;
    }
}
