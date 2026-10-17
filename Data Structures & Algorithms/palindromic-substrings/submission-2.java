class Solution {
    public int countSubstrings(String s) {
        var count = 0;
        var dp = new boolean[s.length()][s.length()];

        for (var len = 1; len <= s.length(); len++) {
            for (var left = 0; left + len <= s.length(); left++) {
                var right = left + len - 1;
                dp[left][right] = s.charAt(left) == s.charAt(right)
                    && (len <= 3 || dp[left + 1][right - 1]);

                if (dp[left][right]) {
                    count++;
                }
            }
        }

        return count;
    }
}
