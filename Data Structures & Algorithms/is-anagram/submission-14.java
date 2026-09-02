class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var freq = new int[26];

        for (var c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (var c : t.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
