class Solution {
    public int numDecodings(String s) {
        var prev2 = 1;
        var prev1 = s.charAt(0) == '0' ? 0 : 1;

        for (var i = 1; i < s.length(); i++) {
            var cur = 0;

            if (s.charAt(i) != '0') {
                cur += prev1;
            }

            var num = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';

            if (num >= 10 && num <= 26) {
                cur += prev2;
            }

            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}