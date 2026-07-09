class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagrams = new HashMap<String, List<String>>();

        for (var str : strs) {
            var keyByte = str.toCharArray();
            Arrays.sort(keyByte);

            var key = new String(keyByte);
            var list = anagrams.computeIfAbsent(key, k -> new ArrayList<String>());
            list.add(str);
        }

        return new ArrayList<>(anagrams.values());
    }
}
