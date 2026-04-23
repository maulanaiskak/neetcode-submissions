class Solution {
    public int numDecodings(String s) {
        // 1012
        // 10 12
        // 10 1 2
        // meaning we need to check each single digit if it's not 0. if it's 0 must be 2 digit. 
        // then ccheck 2 digit that < 26
        // meaning we can check by one way back and 2 way back for 2 digit
        // base case

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
