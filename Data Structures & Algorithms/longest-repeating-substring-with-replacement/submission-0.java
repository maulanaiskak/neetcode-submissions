class Solution {
    public int characterReplacement(String s, int k) {
        var maxLength = 0;
        var left = 0;
        var maxFreq = 0;
        final var freq = new HashMap<Character, Integer>();

        for (var right = 0; right < s.length(); right++) {
            final char currentChar = s.charAt(right);
            freq.put(currentChar, freq.getOrDefault(currentChar, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(currentChar));

            // Shrink window if invalid
            if ((right - left + 1) - maxFreq > k) {
                final char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
