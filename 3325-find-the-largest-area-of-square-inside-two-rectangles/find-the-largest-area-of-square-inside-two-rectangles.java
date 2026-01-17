class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n=bottomLeft.length;
        long maxArea=0;

        for(int i=0;i<n;i++){
            int x1=bottomLeft[i][0];
            int y1=bottomLeft[i][1];

            int x2=topRight[i][0];
            int y2=topRight[i][1];

            for(int j=i+1;j<n;j++){
                int left=Math.max(x1,bottomLeft[j][0]);
                int right=Math.min(x2,topRight[j][0]);

                if(left>=right) continue;

                int bottom=Math.max(y1,bottomLeft[j][1]);
                int top=Math.min(y2,topRight[j][1]);

                if(bottom>=top) continue;

                int width=right-left;
                int height=top-bottom;

                int side=Math.min(width,height);
                if((long) side*side<=maxArea) continue;

                maxArea=(long) side*side;

            }
        }
        return maxArea;
    }
}