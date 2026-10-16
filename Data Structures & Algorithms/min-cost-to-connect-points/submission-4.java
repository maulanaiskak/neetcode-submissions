class Solution {
    public int minCostConnectPoints(int[][] points) {
        var visited = new boolean[points.length];
        var queue = new PriorityQueue<int[]> ((a, b) -> a[1] - b[1]);

        queue.offer(new int[]{0, 0});

        var totalCost = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int node = current[0];
            int cost = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            totalCost += cost;

            for (int next = 0; next < points.length; next++) {
                if (visited[next]) {
                    continue;
                }

                int distance = Math.abs(points[node][0] - points[next][0])
                            + Math.abs(points[node][1] - points[next][1]);

                queue.offer(new int[]{next, distance});
            }
        }

        return totalCost;
    }
}
