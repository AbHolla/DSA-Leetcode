class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int deletions = 0;

        for (int c = 0; c < cols; c++) {
            char prev = strs[0].charAt(c);

            for (int r = 1; r < rows; r++) {
                char curr = strs[r].charAt(c);

                if (curr < prev) {
                    deletions++;
                    break;
                }
                prev = curr;
            }
        }
        return deletions;
    }
}
