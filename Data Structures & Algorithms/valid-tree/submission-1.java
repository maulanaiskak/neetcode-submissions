class Solution {
    private Map<Integer, Set<Integer>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        for (var edge : edges) {
            map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        return !hasCycle(0, -1) && visited.size() == n;
    }

    private boolean hasCycle(int node, int parent) {
        visited.add(node);

        for (int neighbor : map.getOrDefault(node, Collections.emptySet())) {
            if (neighbor == parent) {
                continue;
            }

            if (visited.contains(neighbor) || hasCycle(neighbor, node)) {
                return true;
            }
        }

        return false;
    }
}
