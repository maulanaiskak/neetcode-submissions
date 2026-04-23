class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();

        for (var s : strs) {
            var bytes = s.toCharArray();
            Arrays.sort(bytes);

            var key = new String(bytes);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
