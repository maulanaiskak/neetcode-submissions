class Solution {
    public int lengthOfLongestSubstring(String s) {
        var left = 0;
        var substring = new HashSet<Character>();
        var maxLength = 0;

        for (var right = 0; right < s.length(); right++) {
            while(substring.contains(s.charAt(right))) {
                substring.remove(s.charAt(left));
                left++;
            }

            substring.add(s.charAt(right));
            maxLength = Math.max(maxLength, substring.size());
        }

        return maxLength;
    }
}
