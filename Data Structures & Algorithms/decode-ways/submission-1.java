class Solution {
    public int numDecodings(String s) {
        // Decoding is a DP problem: dp[i] = ways to decode s[0..i-1]
        // We can look back because each decision at i doesn't affect previous ones,
        // so we can reuse already-computed results (optimal substructure).
        //
        // Each position i can be decoded in at most 2 ways:
        // 1. Take 1 digit: s[i-1], valid if != '0'
        //    -> adds dp[i-1] (ways before this digit)
        // 2. Take 2 digits: s[i-2..i-1], valid if forms 10-26
        //    -> adds dp[i-2] (ways before these 2 digits)
        //
        // dp[i] = dp[i-1] (if 1-digit valid) + dp[i-2] (if 2-digit valid)
        // base: dp[0] = 1 (empty string), dp[1] = 0 or 1

        var waysUpToTwoBack = 1; // ways to decode empty string
        var waysUpToOneBack = s.charAt(0) == '0' ? 0 : 1; // ways to decode first element

        for (var i = 2; i <= s.length(); i++) {
            var current = 0;

            if (s.charAt(i - 1) != '0') {
                current += waysUpToOneBack;
            }

            var first = s.charAt(i - 2);
            var second = s.charAt(i - 1);

            if (first == '1' || (first == '2' && second <= '6')) {
                current += waysUpToTwoBack;
            }

            waysUpToTwoBack = waysUpToOneBack;
            waysUpToOneBack = current;
        }

        return waysUpToOneBack;

    }
}
