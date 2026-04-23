class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagrams = new HashMap<String, List<String>>();

        for (var str : strs) {
            var strChar = str.toCharArray();
            Arrays.sort(strChar);

            var sortedStr = new String(strChar);

            var list = anagrams.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);

            anagrams.put(sortedStr, list);
        }

        return new ArrayList<>(anagrams.values());
    }
}
