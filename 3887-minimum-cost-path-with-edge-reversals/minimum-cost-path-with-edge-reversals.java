import java.util.*;

class Solution {

    static class Edge {
        int to;
        int cost;
        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }

    public int minCost(int n, int[][] edges) {

        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // Build expanded graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            // normal edge
            graph[u].add(new Edge(v, w));

            // reversed edge (allowed once per arrival, modeled implicitly)
            graph[v].add(new Edge(u, 2 * w));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        dist[0] = 0;
        pq.add(new long[]{0, 0}); // {node, cost}

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long cost = cur[1];

            if (cost > dist[u]) continue;

            for (Edge e : graph[u]) {
                long newCost = cost + e.cost;
                if (newCost < dist[e.to]) {
                    dist[e.to] = newCost;
                    pq.add(new long[]{e.to, newCost});
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }
}
