class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check odd and even length palindromes
            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);

            int length = Math.max(odd, even);

            if (length > maxLength) {
                maxLength = length;

                // Calculate starting index from center and length
                start = i - (length - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    private int expand(String s, int left, int right) {
        // Expand while both characters match
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Pointers are now outside the valid palindrome
        return right - left - 1;
    }
}