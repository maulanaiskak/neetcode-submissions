class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagrams = new HashMap<String, List<String>>();
        for (var str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            // Build key dari frequency array, e.g. "#2#0#1..."
            var sb = new StringBuilder();
            for (int n : count) {
                sb.append('#').append(n);
            }
            String key = sb.toString();
            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }
}