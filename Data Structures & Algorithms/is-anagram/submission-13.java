class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var charFreq = new int[26];

        for (var c : s.toCharArray()) {
            charFreq[c - 'a']++;
        }

        for (var c : t.toCharArray()) {
            charFreq[c - 'a']--;

            if (charFreq[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
