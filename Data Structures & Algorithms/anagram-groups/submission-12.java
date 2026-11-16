class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var result = new ArrayList<List<String>> ();
        var map = new HashMap<String, List<String>> ();

        for (var str : strs) {
            var chars = str.toCharArray();
            Arrays.sort(chars);

            var key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        for (var value : map.values()) {
            result.add(value);
        }

        return result;
    }
}
