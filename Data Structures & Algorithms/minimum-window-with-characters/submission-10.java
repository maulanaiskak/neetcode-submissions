class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        var freq = new int[128];
        for (var c : t.toCharArray()) {
            freq[c]++;
        }

        var currentFreq = new int[128];
        var left = 0;
        var minLen = Integer.MAX_VALUE;
        var minLeft = 0;

        for (var right = 0; right < s.length(); right++) {
            currentFreq[s.charAt(right)]++;

            while (windowCoversT(freq, currentFreq)) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                currentFreq[s.charAt(left)]--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    private boolean windowCoversT(int[] freq, int[] currentFreq) {
        for (var i = 0; i < 128; i++) {
            if (currentFreq[i] < freq[i]) {
                return false;
            }
        }
        return true;
    }
}