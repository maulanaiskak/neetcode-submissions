class Solution {
    public int numDecodings(String s) {
        var prev = 1;
        var curr = s.charAt(0) == '0' ? 0 : 1;

        for (var i = 2; i <= s.length(); i++) {
            var temp = 0;

            if (s.charAt(i - 1) != '0') {
                temp += curr;
            }

            var twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (twoDigit >= 10 && twoDigit <= 26) {
                temp += prev;
            }

            prev = curr;
            curr = temp;
        }

        return curr;
    }
}
