class Solution {
    public double largestTriangleArea(int[][] points) {
        int n=points.length;
        double maxArea=0.0;

        for(int i=0;i<n;i++){
            for( int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    
                    // Shoelace formula for area of triangle given 3 points
                    // area = 0.5 * |x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)|

                    double area=0.5 * Math.abs(
                        points[i][0]*(points[j][1]-points[k][1])+
                        points[j][0]*(points[k][1]-points[i][1])+
                        points[k][0]*(points[i][1]-points[j][1])
                    );
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
}