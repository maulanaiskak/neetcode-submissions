class Solution {
    public String longestPalindrome(String s) {
        var maxLength  = 0;
        var start = 0;

        for (var i = 0; i < s.length(); i++) {
            var odd = expand(s, i, i);
            var even = expand(s, i, i + 1);
            var length = Math.max(odd, even);
            if (length > maxLength) {
                maxLength = length;
                start = i - (length - 1) / 2;
             }
        }

        return s.substring(start, start + maxLength);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
