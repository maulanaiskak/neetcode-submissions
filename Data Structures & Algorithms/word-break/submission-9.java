class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // To determine whether a string can be segmented into dictionary words,
        // we check whether each prefix can be formed using wordDict.
        //
        // Example: s = "leetcode", wordDict = ["leet", "code"]
        // "leet" + "code" = "leetcode" -> true
        //
        // dp[i] represents whether the substring from index 0 to i - 1
        // can be segmented using the available words in wordDict.
        //
        // We iterate forward because dp[i] depends on previous DP states.

        var dp = new boolean[s.length() + 1];

        // Base case: an empty string can always be segmented.
        dp[0] = true;

        for (var i = 1; i <= s.length(); i++) {
            for (var word : wordDict) {

                // Check whether the current word fits within the processed prefix.
                if (i >= word.length()) {
                    // Calculate where the current word starts.
                    var start = i - word.length();

                    // Check two conditions:
                    // 1. The substring before the current word can be segmented.
                    // 2. The current substring matches the dictionary word.
                    if (dp[start] && s.substring(start, i).equals(word)) {
                        // Both conditions are satisfied,
                        // so the entire prefix ending at i can be segmented.
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        // dp[s.length()] represents whether the entire string can be segmented.
        return dp[s.length()];
    }
}