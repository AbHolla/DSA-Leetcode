import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = 1_000_000_007;

        // Step 1: Add boundary fences
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[1] = m;
        for (int i = 0; i < hFences.length; i++) {
            h[i + 2] = hFences[i];
        }

        v[0] = 1;
        v[1] = n;
        for (int i = 0; i < vFences.length; i++) {
            v[i + 2] = vFences[i];
        }

        // Step 2: Sort fences
        Arrays.sort(h);
        Arrays.sort(v);

        // Step 3: Store all possible heights
        Set<Integer> heights = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                heights.add(h[j] - h[i]);
            }
        }

        // Step 4: Match widths and find max square side
        long maxSide = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int width = v[j] - v[i];
                if (heights.contains(width)) {
                    maxSide = Math.max(maxSide, width);
                }
            }
        }

        // Step 5: Return result
        if (maxSide == 0) return -1;

        return (int) ((maxSide * maxSide) % MOD);
    }
}
