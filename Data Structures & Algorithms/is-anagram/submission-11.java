class Solution {
    public boolean isAnagram(String s, String t) {
        var freq = new int[26];

        for (var c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (var c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        for (var count : freq) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
