class Solution {
    public boolean isAnagram(String s, String t) {
        var freq = new HashMap<Character, Integer>();

        for (var c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (var c : t.toCharArray()) {
            if (!freq.containsKey(c)) {
                return false;
            }

            freq.put(c, freq.get(c) - 1);
        }

        for (var entry : freq.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }
}
