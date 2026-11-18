class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        var freq1 = new int[26];
        for (var c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        var left = 0;
        var freq2 = new int[26];

        for (var right = 0; right < s2.length(); right++) {
            freq2[s2.charAt(right) - 'a']++;
            var len = right - left + 1;

            if (len > s1.length()) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
                len--;
            }

            if (len == s1.length()) {
                var match = true;

                for (var i = 0; i < 26; i++) {
                    if (freq1[i] != freq2[i]) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    return true;
                }
            }
        }

        return false;
    }
}