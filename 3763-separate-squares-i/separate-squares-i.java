class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        // Compute total area and y-range
        for (int[] sq : squares) {
            long l = sq[2];
            totalArea += (double) l * l;
            low = Math.min(low, sq[1]);
            high = Math.max(high, sq[1] + l);
        }

        double target = totalArea / 2.0;

        // Binary search on y
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2;
            double areaBelow = 0;

            for (int[] sq : squares) {
                double y = sq[1];
                double l = sq[2];

                if (mid <= y) {
                    continue;
                } else if (mid >= y + l) {
                    areaBelow += l * l;
                } else {
                    areaBelow += (mid - y) * l;
                }
            }

            if (areaBelow < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
