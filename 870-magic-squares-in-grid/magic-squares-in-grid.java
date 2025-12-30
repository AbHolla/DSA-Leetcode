class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;

        for(int i=0;i+2<row;i++){
            for(int j=0;j+2<col;j++){
                if(isMagic(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagic(int[][] g,int r,int c){
        if(g[r+1][c+1]!=5){
            return false;
        }

        boolean[] seen=new boolean[10];
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                int v=g[i][j];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }
        }
        return g[r][c] + g[r][c + 1] + g[r][c + 2] == 15 &&
               g[r + 1][c] + g[r + 1][c + 1] + g[r + 1][c + 2] == 15 &&
               g[r + 2][c] + g[r + 2][c + 1] + g[r + 2][c + 2] == 15 &&

               g[r][c] + g[r + 1][c] + g[r + 2][c] == 15 &&
               g[r][c + 1] + g[r + 1][c + 1] + g[r + 2][c + 1] == 15 &&
               g[r][c + 2] + g[r + 1][c + 2] + g[r + 2][c + 2] == 15 &&

               g[r][c] + g[r + 1][c + 1] + g[r + 2][c + 2] == 15 &&
               g[r][c + 2] + g[r + 1][c + 1] + g[r + 2][c] == 15;
    }
}