class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagrams = new HashMap<String, List<String>>();

        for (var str : strs) {
            var keyChars = str.toCharArray();
            Arrays.sort(keyChars);

            var key = new String(keyChars);
            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }
}
