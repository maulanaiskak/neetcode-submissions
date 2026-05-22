class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        var freq = new int[128];
        for (var c : t.toCharArray()) {
            freq[c]++;
        }
        var left = 0;
        var right = 0;
        var minLen = Integer.MAX_VALUE;
        var minLeft = 0;
        var currentFreq = new int[128];
        while (right < s.length()) {
            currentFreq[s.charAt(right)]++;
            while (isValid(freq, currentFreq)) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                currentFreq[s.charAt(left)]--;
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    private boolean isValid(int[] freq, int[] currentFreq) {
        for (var i = 0; i < 128; i++) {
            if (currentFreq[i] < freq[i]) {
                return false;
            }
        }
        return true;
    }
}