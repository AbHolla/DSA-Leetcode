class Solution {
    int R, C;
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        R = row;
        C = col;

        int left = 0, right = row * col, ans = 0;

        // Binary search on days
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(mid, cells)) {
                ans = mid;       
                left = mid + 1;
            } else {
                right = mid - 1;  
            }
        }
        return ans;
    }

    private boolean canCross(int day, int[][] cells) {
        int[][] grid = new int[R][C];

        
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1; 
        }

        boolean[][] visited = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();

        for (int c = 0; c < C; c++) {
            if (grid[0][c] == 0) {
                q.offer(new int[]{0, c});
                visited[0][c] = true;
            }
        }

        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            
            if (r == R - 1) return true;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
                    !visited[nr][nc] && grid[nr][nc] == 0) {

                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
