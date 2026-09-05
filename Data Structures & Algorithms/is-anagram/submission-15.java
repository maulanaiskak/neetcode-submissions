class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var freq = new int[26];

        for (var character : s.toCharArray()) {
            freq[character - 'a']++;
        }

        for (var character : t.toCharArray()) {
            freq[character - 'a']--;
            if (freq[character - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
