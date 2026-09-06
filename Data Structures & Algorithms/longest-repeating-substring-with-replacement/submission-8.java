class Solution {
    public int characterReplacement(String s, int k) {
        var freq = new int[26];
        var highestFreq = 0;
        var left = 0;
        var right = 0;
        var maxLength = 0;

        while (right < s.length()) {
            freq[s.charAt(right) - 'A']++;
            highestFreq = Math.max(highestFreq, freq[s.charAt(right) - 'A']);
            
            if (right - left + 1 - highestFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
