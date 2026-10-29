class Solution {
    public String longestPalindrome(String s) {
        // To find a palindrome, we can start from the middle and expand outward.
        // For example, given “ababd”, if we start at index 2 (‘a’):
        // Expand one step to the left and right: “bab” -> palindrome with length 3.
        // Expand further: “ababd” -> not a palindrome.
        // However, starting from the middle of the string does not always find the longest palindrome.
        // For example, starting at index 1 (‘b’) gives us “aba”, which is a palindrome with length 3.
        // To find the longest palindrome, we check every index as a potential center
        // and expand outward to find the longest palindrome around that center.
        // We check both odd-length palindromes (one center) and even-length palindromes (two centers).
        // We also track the starting index and maximum length because the result must be a substring.
        var maxLen = 0;
        var start = 0;

        for (var i = 0; i < s.length(); i++) {
            var odd = expand(s, i, i);
            var even = expand(s, i, i+1);
            var len = Math.max(odd, even);
            
            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expand(String s, int left, int right) {
        // Expand outward while both pointers are within bounds and the characters match.
        // Once the characters no longer match or a pointer goes out of bounds,
        // stop expanding and return the length of the palindrome found.
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // The pointers have moved one position beyond the palindrome's boundaries.
        return right - left - 1;
    }
}
