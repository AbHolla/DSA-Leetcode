import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();

        PriorityQueue<long[]> busyRooms =
                new PriorityQueue<>((a, b) ->
                        a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        // Process each meeting
        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free all rooms whose meetings have ended by 'start'
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            // If a room is available, use it
            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
                count[room]++;
            }
            // Otherwise, delay the meeting
            else {
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];

                busyRooms.offer(new long[]{newEnd, room});
                count[room]++;
            }
        }
        int maxMeetings = 0;
        int resultRoom = 0;

        for (int i = 0; i < n; i++) {
            if (count[i] > maxMeetings) {
                maxMeetings = count[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
