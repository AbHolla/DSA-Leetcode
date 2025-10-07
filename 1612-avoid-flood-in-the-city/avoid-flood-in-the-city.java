import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> full = new HashMap<>(); // lake -> last fill day
        TreeSet<Integer> dryDays = new TreeSet<>();   // available dry days

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                int lake = rains[i];
                if (full.containsKey(lake)) {
                    // find a dry day after the last time this lake was filled
                    Integer dry = dryDays.higher(full.get(lake));
                    if (dry == null) return new int[0]; // flood unavoidable

                    ans[dry] = lake;  // dry this lake on that day
                    dryDays.remove(dry);
                }
                full.put(lake, i);   // mark lake as full
                ans[i] = -1;
            } else {
                dryDays.add(i);  // mark this as a dry day
                ans[i] = 1;      // default, may change later
            }
        }
        return ans;
    }
}
