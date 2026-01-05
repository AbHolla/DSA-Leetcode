class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long tSum=0;
        int negCount=0;
        int minAbs=Integer.MAX_VALUE;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int val=matrix[i][j];

                if(val<0){
                    negCount++;
                }
                int absVal=Math.abs(val);
                tSum+=absVal;

                minAbs=Math.min(minAbs,absVal);
            }
        }

        if(negCount%2==1){
            tSum-=2L*minAbs;
        }
        return tSum;
    }
}