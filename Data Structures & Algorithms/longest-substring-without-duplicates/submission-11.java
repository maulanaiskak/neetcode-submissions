class Solution {
    public int lengthOfLongestSubstring(String s) {
        var left = 0;
        var right = 0;
        var set = new HashSet<Character>();
        var length = 0;

        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            length = Math.max(length, right - left + 1);
            set.add(s.charAt(right));
            right++;
        }

        return length;
    }
}
