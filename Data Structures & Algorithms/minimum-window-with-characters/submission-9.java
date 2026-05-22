class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        var freq = new int[128];
        for (var c : t.toCharArray()) {
            freq[c]++;
        }
        var required = (int) t.chars().distinct().count();
        var left = 0;
        var right = 0;
        var minLen = Integer.MAX_VALUE;
        var minLeft = 0;
        var matches = 0;
        var currentFreq = new int[128];
        while (right < s.length()) {
            var rc = s.charAt(right);
            currentFreq[rc]++;
            if (currentFreq[rc] == freq[rc]) {
                matches++;
            }
            while (matches == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                var lc = s.charAt(left);
                if (currentFreq[lc] == freq[lc]) {
                    matches--;
                }
                currentFreq[lc]--;
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}