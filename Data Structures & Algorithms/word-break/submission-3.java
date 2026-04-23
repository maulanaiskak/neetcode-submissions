class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Word break is a DP problem: dp[i] = true if s[0..i-1] can be segmented into valid words.
        //
        // For each position i, try all possible last words s[j..i-1] where j < i.
        // If dp[j] is true (s[0..j-1] is valid) and s[j..i-1] exists in dict -> dp[i] = true.
        //
        // e.g. s="leetcode", dict=["leet","code"]:
        //   dp[4]: j=0, dp[0]=true and "leet" in dict -> dp[4]=true
        //   dp[8]: j=4, dp[4]=true and "code" in dict -> dp[8]=true
        //
        // base: dp[0] = true (empty string is always valid)

        var dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (var i = 1; i <= s.length(); i++) {
            for (var j = 0; j < i; j++) {
                var lastWord = s.substring(j, i);
                var isValid = dp[j] && wordDict.contains(lastWord);
                if (isValid) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
