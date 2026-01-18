class Solution {

    public int largestMagicSquare(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        // Prefix sums for rows and columns
        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];

        // Build row prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
            }
        }

        // Build column prefix sums
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }

        // Try square sizes from largest to smallest
        for (int size = Math.min(m, n); size >= 2; size--) {

            for (int r = 0; r + size <= m; r++) {
                for (int c = 0; c + size <= n; c++) {

                    // Reference sum (first row)
                    int sum = row[r][c + size] - row[r][c];
                    boolean valid = true;

                    // Check all rows
                    for (int i = 1; i < size && valid; i++) {
                        if (row[r + i][c + size] - row[r + i][c] != sum) {
                            valid = false;
                        }
                    }

                    // Check all columns
                    for (int j = 0; j < size && valid; j++) {
                        if (col[r + size][c + j] - col[r][c + j] != sum) {
                            valid = false;
                        }
                    }

                    if (!valid) continue;

                    // Check main diagonal
                    int d1 = 0, d2 = 0;
                    for (int i = 0; i < size; i++) {
                        d1 += grid[r + i][c + i];
                        d2 += grid[r + i][c + size - 1 - i];
                    }

                    if (d1 == sum && d2 == sum) {
                        return size; // Largest found
                    }
                }
            }
        }

        // At minimum, 1x1 is always a magic square
        return 1;
    }
}
