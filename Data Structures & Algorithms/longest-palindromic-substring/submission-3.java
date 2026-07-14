class Solution {
    public String longestPalindrome(String s) {
        var start = 0;
        var end = 0;

        for (var i = 0; i < s.length(); i++) {
            var odd = expand(i, i, s);
            var even = expand(i, i+1, s);
            var len = Math.max(odd, even);

            if (len > end - start) {
                start = i - (len - 1)/ 2;
                end = i + len/2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
