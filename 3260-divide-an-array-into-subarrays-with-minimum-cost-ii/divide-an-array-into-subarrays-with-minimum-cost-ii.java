import java.util.*;

class Solution {

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int need = k - 1;

        TreeMap<Integer, Integer> small = new TreeMap<>(); // k-1 smallest
        TreeMap<Integer, Integer> large = new TreeMap<>();

        int smallSize = 0;
        long sumSmall = 0;

        int L = 1;
        int R = Math.min(n - 1, 1 + dist);

        // build first window
        for (int i = L; i <= R; i++) {
            add(small, nums[i]);
            smallSize++;
            sumSmall += nums[i];
        }

        // balance first window
        while (smallSize > need) {
            int x = small.lastKey();
            remove(small, x);
            smallSize--;
            sumSmall -= x;
            add(large, x);
        }

        long ans = (smallSize == need) ? sumSmall : Long.MAX_VALUE;

        // slide window
        for (L = 2; L <= n - 1; L++) {
            int out = nums[L - 1];

            if (small.containsKey(out)) {
                remove(small, out);
                smallSize--;
                sumSmall -= out;
            } else {
                remove(large, out);
            }

            int newR = L + dist;
            if (newR <= n - 1) {
                int v = nums[newR];
                if (smallSize == 0 || v <= small.lastKey()) {
                    add(small, v);
                    smallSize++;
                    sumSmall += v;
                } else {
                    add(large, v);
                }
            }

            // rebalance
            while (smallSize > need) {
                int x = small.lastKey();
                remove(small, x);
                smallSize--;
                sumSmall -= x;
                add(large, x);
            }

            while (smallSize < need && !large.isEmpty()) {
                int x = large.firstKey();
                remove(large, x);
                add(small, x);
                smallSize++;
                sumSmall += x;
            }

            if (smallSize == need) {
                ans = Math.min(ans, sumSmall);
            }
        }

        return ans + nums[0];
    }

    private void add(TreeMap<Integer,Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    private void remove(TreeMap<Integer,Integer> map, int x) {
        int c = map.get(x);
        if (c == 1) map.remove(x);
        else map.put(x, c - 1);
    }
}
