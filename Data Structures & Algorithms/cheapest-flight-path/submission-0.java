class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        // k stops = maximum k + 1 flights
        for (int i = 0; i <= k; i++) {
            // Snapshot prevents using multiple flights in one iteration
            int[] next = dist.clone();

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                // Cannot travel from an unreachable city
                if (dist[from] == INF) {
                    continue;
                }

                // Relax using previous iteration's distances
                next[to] = Math.min(next[to], dist[from] + price);
            }

            dist = next;
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}