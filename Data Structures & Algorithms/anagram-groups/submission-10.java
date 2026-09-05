class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagrams = new HashMap<String, List<String>>();

        for (var str : strs) {
            var strChars = str.toCharArray();
            Arrays.sort(strChars);

            var key = new String(strChars);
            var value = anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }
}
