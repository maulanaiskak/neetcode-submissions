class Solution {
    public int characterReplacement(String s, int k) {
        var freq = new int[26];
        var left = 0;
        var maxFreq = 0;
        var maxLen = 0;

        for (var right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
