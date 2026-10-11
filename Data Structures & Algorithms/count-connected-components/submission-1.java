class Solution {
    private Map<Integer, Set<Integer>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        for (var edge : edges) {
            map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        var count = 0;

        for (var i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node) {
        visited.add(node);

        for (var neighbor : map.getOrDefault(node, Collections.emptySet())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }
}
