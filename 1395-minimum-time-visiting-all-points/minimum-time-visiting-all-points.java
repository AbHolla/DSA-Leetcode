class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        // Traverse through consecutive points
        for (int i = 1; i < points.length; i++) {

            // Previous point
            int x1 = points[i - 1][0];
            int y1 = points[i - 1][1];

            // Current point
            int x2 = points[i][0];
            int y2 = points[i][1];

            // Distance in x and y directions
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);

            // Minimum time to move between two points
            totalTime += Math.max(dx, dy);
        }

        return totalTime;
    }
}
