class Solution {
    public int characterReplacement(String s, int k) {
        var maxLen = 0;
        var left = 0;
        var right = 0;
        var freq = new HashMap<Character, Integer>();
        var maxFreq = 0;

        while (right < s.length()) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(right)));

            while (right - left + 1 - maxFreq > k) {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
