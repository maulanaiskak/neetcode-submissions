class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var groups = new HashMap<String, List<String>>();

        for (var str : strs) {
            var chars = str.toCharArray();
            Arrays.sort(chars);
            var key = new String(chars);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            groups.get(key).add(str);
        }

        return groups.values().stream().toList();
    }
}
