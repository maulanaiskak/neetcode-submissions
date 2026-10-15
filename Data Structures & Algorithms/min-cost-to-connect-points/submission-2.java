class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            // Find the unvisited node with the minimum cost
            int node = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] &&
                    (node == -1 || minDist[j] < minDist[node])) {
                    node = j;
                }
            }

            // Add the node to MST
            visited[node] = true;
            totalCost += minDist[node];

            // Update minimum connection costs
            for (int next = 0; next < n; next++) {
                if (visited[next]) {
                    continue;
                }

                int distance = Math.abs(points[node][0] - points[next][0])
                             + Math.abs(points[node][1] - points[next][1]);

                minDist[next] = Math.min(minDist[next], distance);
            }
        }

        return totalCost;
    }
}