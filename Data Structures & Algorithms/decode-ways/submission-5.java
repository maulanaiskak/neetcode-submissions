class Solution {
    public int numDecodings(String s) {
        // To count the number of decodings, we consider both single-digit
        // and two-digit numbers.
        //
        // Example: "1012"
        // At index 3, the current digit is '2':
        // - Single digit '2': valid, so add prev1.
        // - Two digits '12': valid, so add prev2.
        //
        // If the two-digit number were '01', it would be invalid.

        // Base cases:
        // prev2 = 1 because there is exactly one way to decode an empty string.
        // This is needed when decoding the first two digits together, e.g. "10" -> "J".
        var prev2 = 1;

        // There is 1 way to decode a non-zero first digit, but 0 ways to decode '0' alone.
        var prev1 = s.charAt(0) == '0' ? 0 : 1;

        for (var i = 1; i < s.length(); i++) {
            var temp = 0;

            // Decode the current digit individually.
            if (s.charAt(i) != '0') {
                temp += prev1;
            }

            // Decode the current and previous digits together.
            var twoDigit = (s.charAt(i - 1) - '0') * 10
                    + (s.charAt(i) - '0');

            if (twoDigit >= 10 && twoDigit <= 26) {
                temp += prev2;
            }

            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}