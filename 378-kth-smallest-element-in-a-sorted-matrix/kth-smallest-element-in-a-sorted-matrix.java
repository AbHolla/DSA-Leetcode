import java.util.*;

public class Solution{
    static class Cell {
        int val;
        int row;
        int col;
        Cell(int v, int r, int c) {
            val = v;
            row = r;
            col = c;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // Min-heap ordered by cell value
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Push first element of each row, up to k rows
        for (int r = 0; r < Math.min(n, k); r++) {
            minHeap.offer(new Cell(matrix[r][0], r, 0));
        }

        // Pop the smallest element k-1 times
        for (int count = 0; count < k - 1; count++) {
            Cell curr = minHeap.poll();
            if (curr.col + 1 < n) { // push next element in the same row
                minHeap.offer(new Cell(matrix[curr.row][curr.col + 1],curr.row,curr.col + 1));
            }
        }
        return minHeap.poll().val;
    }    
}
