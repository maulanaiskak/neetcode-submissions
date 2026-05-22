class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        var freq = new int[26];
        for (var c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        var left = 0;
        var right = s1.length() - 1;

        while (right < s2.length()) {
            var currentFreq = new int[26];

            for (var i = left; i <= right; i++) {
                currentFreq[s2.charAt(i) - 'a']++;
            }

            var match = true;
            for (var i =0 ; i < 26; i++) {
                if (freq[i] != currentFreq[i]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return true;
            }

            left++;
            right++;
        }

        return false;
    }
}
