import java.util.*;

class Solution {

    static class Pair {
        long sum;
        int left;
        Pair(long s, int l) {
            sum = s;
            left = l;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nums[i];

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            alive[i] = true;
        }
        next[n - 1] = -1;

        int bad = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (arr[i] > arr[i + 1]) bad++;
        }

        // ✅ already non-decreasing
        if (bad == 0) return 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.sum == b.sum ? a.left - b.left : Long.compare(a.sum, b.sum)
        );

        for (int i = 0; i + 1 < n; i++) {
            pq.add(new Pair(arr[i] + arr[i + 1], i));
        }

        int ops = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int i = p.left;

            if (!alive[i]) continue;
            int j = next[i];
            if (j == -1 || !alive[j]) continue;

            // discard stale pair
            if (arr[i] + arr[j] != p.sum) continue;

            // remove old violations
            if (prev[i] != -1 && arr[prev[i]] > arr[i]) bad--;
            if (arr[i] > arr[j]) bad--;
            if (next[j] != -1 && arr[j] > arr[next[j]]) bad--;

            // merge
            arr[i] += arr[j];
            alive[j] = false;
            next[i] = next[j];
            if (next[j] != -1) prev[next[j]] = i;

            // add new violations
            if (prev[i] != -1 && arr[prev[i]] > arr[i]) bad++;
            if (next[i] != -1 && arr[i] > arr[next[i]]) bad++;

            ops++;

            //correct stopping condition
            if (bad == 0) return ops;

            // push new adjacent pairs
            if (prev[i] != -1)
                pq.add(new Pair(arr[prev[i]] + arr[i], prev[i]));
            if (next[i] != -1)
                pq.add(new Pair(arr[i] + arr[next[i]], i));
        }

        return ops;
    }
}
