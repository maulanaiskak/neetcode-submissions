class Solution {
    public String longestPalindrome(String s) {
        var result = "";

        for (var i = 0; i < s.length(); i++) {
            var len = Math.max(
                expand(i, i, s),
                expand(i, i + 1, s)
            );

            if (len > result.length()) {
                var start = i - (len - 1) / 2;
                result = s.substring(start, start + len);
            }
        }

        return result;
    }

    private int expand(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
