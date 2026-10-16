class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        var map = new HashMap<String, PriorityQueue<String>>();
        for (var ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        var result = new LinkedList<String>();
        dfs("JFK", map, result);

        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> map, LinkedList<String> result) {
        while (!map.getOrDefault(airport, new PriorityQueue<>()).isEmpty()) {
            var next = map.get(airport).poll();
            dfs(next, map, result);
        }

        result.addFirst(airport);
    }
}
