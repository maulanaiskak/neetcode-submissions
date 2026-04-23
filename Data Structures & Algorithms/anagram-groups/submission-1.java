class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // we can use map for this problem. the key is the sorted string and the value is the anagram of key

        var group = new HashMap<String, List<String>>();

        for (var str : strs) {
            var sorted = sortString(str);
            var value = group.get(sorted);

            if (value == null) {
                value = new ArrayList<>();
                value.add(str);
                group.put(sorted, value);
            } else {
                value.add(str);
            }
        }

        var result = new ArrayList<List<String>>();

        for (var entry : group.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private String sortString(String str) {
        var chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
