class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 0;
        int start = 0;

        for (int len = 1; len <= n; len++) {
            for (int left = 0; left + len <= n; left++) {
                int right = left + len - 1;

                if (s.charAt(left) == s.charAt(right)) {
                    if (len <= 3 || dp[left + 1][right - 1]) {
                        dp[left][right] = true;
                    }

                    if (dp[left][right] && len > maxLength) {
                        maxLength = len;
                        start = left;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
} 
