class Solution {
    private Map<Integer, Set<Integer>> map = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        for (var edge : edges) {
            var visited = new HashSet<Integer>();
            if (hasPath(edge[0], edge[1], visited)) {
                return edge;
            }

            map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);  
        }

        return null;  
    }

    private boolean hasPath(int node, int target, Set<Integer> visited) {
        if (node == target) {
            return true;
        }

        visited.add(node);

        for (var neighbor : map.getOrDefault(node, new HashSet<>())) {
            if (!visited.contains(neighbor) && hasPath(neighbor, target, visited)) {
                return true;
            }
        }

        return false;
    }
}
