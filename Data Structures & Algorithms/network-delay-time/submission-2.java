class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        var map = new HashMap<Integer, List<int[]>>();
        for (var time : times) {
            map.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }

        var dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        var queue = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
        queue.offer(new int[] {k, 0});

        while (!queue.isEmpty()) {
            var data = queue.poll();
            var node = data[0];
            var time = data[1];

            for (var neighbor : map.getOrDefault(node, new ArrayList<>())) {
                var neighborNode = neighbor[0];
                var neighborTime = neighbor[1];
                var newDist = time + neighborTime;

                if (newDist < dist[neighborNode]) {
                    dist[neighborNode] = newDist;
                    queue.offer(new int[] {neighborNode, newDist});
                }
            }
        }

        var result = 0;
        for (var i = 1; i < n + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            result = Math.max(result, dist[i]);
        }

        return result;
    }
}
