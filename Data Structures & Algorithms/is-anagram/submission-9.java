class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var freq = new int[26];
        for (var i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (var f : freq) {
            if (f < 0) {
                return false;
            }
        }

        return true;
    }
}
