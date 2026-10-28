class Solution {
    public int numDecodings(String s) {
        var prev2 = 1;
        var prev1 = s.charAt(0) == '0' ? 0 : 1;

        for (var i = 1; i < s.length(); i++) {
            var temp = 0;

            if (s.charAt(i) != '0') {
                temp += prev1;
            }

            var twoDigit = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (twoDigit >= 10 && twoDigit <= 26) {
                temp += prev2;
            }

            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}
