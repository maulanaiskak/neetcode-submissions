class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        var graph = new HashMap<Integer, List<int[]>>();
        for (var time : times) {
            graph.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }

        var dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            var current = pq.poll();

            var node = current[0];
            var distance = current[1];

            if (distance > dist[node]) {
                continue;
            }

            for (var neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                var newDist = distance + neighbor[1];

                if (newDist < dist[neighbor[0]]) {
                    dist[neighbor[0]] = newDist;
                    pq.offer(new int[]{neighbor[0], newDist});
                }
            }
        }

        var result = 0;
        for (var i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            result = Math.max(result, dist[i]);
        }

        return result;
    }
}
