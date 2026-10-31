class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // To determine whether a string can be segmented into dictionary words,
        // we check whether each substring can be formed using wordDict.
        //
        // Example: s = "leetcode", wordDict = ["leet", "code"]
        // "leet" + "code" = "leetcode" -> true
        //
        // dp[i] represents whether the substring starting at index i
        // and ending at the end of the string can be segmented
        // using the available words in wordDict.
        //
        // We iterate backwards because dp[i] depends on the DP state
        // of the remaining substring, which is located at a higher index.

        var dp = new boolean[s.length() + 1];

        // Base case: an empty string can always be segmented.
        // This allows a word that reaches the end of the string to be valid.
        dp[s.length()] = true;

        for (var i = s.length() - 1; i >= 0; i--) {
            for (var word : wordDict) {

                // Check whether the current word fits within the remaining string.
                // i + word.length() must not exceed the string length.
                if (i + word.length() <= s.length()
                    && s.substring(i, i + word.length()).equals(word)) {

                    // The current word matches the substring starting at i.
                    // Now check whether the remaining substring can also be segmented.
                    //
                    // i + word.length() represents the starting index
                    // of the remaining substring after the current word.
                    //
                    // If the remaining substring is valid, dp[i] becomes true.
                    dp[i] = dp[i + word.length()];
                }

                // If we already found a valid segmentation,
                // there is no need to check other dictionary words.
                if (dp[i]) {
                    break;
                }
            }
        }

        // dp[0] represents whether the entire string can be segmented.
        return dp[0];
    }
}