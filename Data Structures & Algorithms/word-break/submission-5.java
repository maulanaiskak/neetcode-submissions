class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Word break: canBreak[end] = true if s[0..end-1] can be segmented into valid dict words.
        //
        // For each end position, try all split points start where start < end:
        //   - if canBreak[start] is true -> s[0..start-1] is already valid
        //   - if s[start..end-1] exists in dict -> the last word is valid
        //   - both true -> canBreak[end] = true
        //
        // e.g. s="leetcode", dict=["leet","code"]:
        //   end=4: start=0, canBreak[0]=true and "leet" in dict -> canBreak[4]=true
        //   end=8: start=4, canBreak[4]=true and "code" in dict -> canBreak[8]=true
        //
        // base: canBreak[0] = true (empty string is always valid)

        var canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;

        for (var end = 1; end <= s.length(); end++) {
            for (var start = 0; start < end; start++) {
                var lastWord = s.substring(start, end);
                var prefixIsBreakable = canBreak[start];
                var lastWordInDict = wordDict.contains(lastWord);

                if (prefixIsBreakable && lastWordInDict) {
                    canBreak[end] = true;
                    break;
                }
            }
        }

        return canBreak[s.length()];
    }
}