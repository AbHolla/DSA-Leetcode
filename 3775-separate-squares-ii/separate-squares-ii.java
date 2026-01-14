import java.util.*;

class Solution {

    static class Event {
        long y;
        long x1, x2;
        int type; // +1 add, -1 remove

        Event(long y, long x1, long x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, x, x + l, +1));
            events.add(new Event(y + l, x, x + l, -1));
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        // Active x-intervals
        TreeMap<Long, Integer> map = new TreeMap<>();

        double totalArea = 0;
        long prevY = events.get(0).y;

        // First pass: compute total union area
        for (Event e : events) {
            long currY = e.y;
            long dy = currY - prevY;

            if (dy > 0) {
                long unionX = unionLength(map);
                totalArea += unionX * (double) dy;
            }

            update(map, e.x1, e.x2, e.type);
            prevY = currY;
        }

        double half = totalArea / 2.0;

        // Second pass: find minimal y
        map.clear();
        prevY = events.get(0).y;
        double areaSoFar = 0;

        for (Event e : events) {
            long currY = e.y;
            long dy = currY - prevY;

            if (dy > 0) {
                long unionX = unionLength(map);
                double blockArea = unionX * (double) dy;

                if (areaSoFar + blockArea >= half) {
                    return prevY + (half - areaSoFar) / unionX;
                }

                areaSoFar += blockArea;
            }

            update(map, e.x1, e.x2, e.type);
            prevY = currY;
        }

        return prevY;
    }

    // Add or remove x-interval
    private void update(TreeMap<Long, Integer> map, long x1, long x2, int type) {
        map.put(x1, map.getOrDefault(x1, 0) + type);
        map.put(x2, map.getOrDefault(x2, 0) - type);

        if (map.get(x1) == 0) map.remove(x1);
        if (map.get(x2) == 0) map.remove(x2);
    }

    // Compute union length on x-axis
    private long unionLength(TreeMap<Long, Integer> map) {
        long length = 0;
        int active = 0;
        long prevX = 0;

        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            long x = e.getKey();
            if (active > 0) {
                length += x - prevX;
            }
            active += e.getValue();
            prevX = x;
        }
        return length;
    }
}
