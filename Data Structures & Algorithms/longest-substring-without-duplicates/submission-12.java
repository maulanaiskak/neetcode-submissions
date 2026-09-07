class Solution {
    public int lengthOfLongestSubstring(String s) {
        var set = new HashSet<Character>();
        var left = 0;
        var right = 0;
        var maxLen = 0;

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
                continue;
            }

            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, set.size());
            right++;
        }

        return maxLen;
    }
}
