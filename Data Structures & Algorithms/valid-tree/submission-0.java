class Solution {
    private List<List<Integer>> graph;
    private boolean[] visited;

    public boolean validTree(final int n, final int[][] edges) {
        // A tree with n nodes must have exactly n - 1 edges.
        if (edges.length != n - 1) {
            return false;
        }

        graph = new ArrayList<>();
        visited = new boolean[n];

        for (var node = 0; node < n; node++) {
            graph.add(new ArrayList<>());
        }

        for (final var edge : edges) {
            final var from = edge[0];
            final var to = edge[1];

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        if (hasCycle(0, -1)) {
            return false;
        }

        for (final var isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(final int node, final int parent) {
        visited[node] = true;

        for (final var neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue;
            }

            if (visited[neighbor]) {
                return true;
            }

            if (hasCycle(neighbor, node)) {
                return true;
            }
        }

        return false;
    }
}