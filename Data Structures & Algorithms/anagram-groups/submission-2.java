class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // we can use map for this problem. the key is the sorted string and the value is the anagram of key

        var group = new HashMap<String, List<String>>();

        for (var str : strs) {
            var sorted = sortString(str);
            group.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(group.values());
    }

    private String sortString(String str) {
        var chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
