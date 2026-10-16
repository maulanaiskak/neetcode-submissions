class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Register all characters, including isolated ones
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Build dependencies from the first differing character
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i], b = words[i + 1];

            if (a.length() > b.length() && a.startsWith(b)) {
                return "";
            }

            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                char from = a.charAt(j), to = b.charAt(j);

                if (from != to) {
                    // Avoid counting duplicate edges
                    if (graph.get(from).add(to)) {
                        indegree.put(to, indegree.get(to) + 1);
                    }
                    break;
                }
            }
        }

        // Start with characters having no prerequisites
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) queue.offer(c);
        }

        // Kahn's Algorithm: remove dependencies using BFS
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            for (char next : graph.get(current)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        // Unprocessed characters indicate a cycle
        return result.length() == indegree.size() ? result.toString() : "";
    }
}