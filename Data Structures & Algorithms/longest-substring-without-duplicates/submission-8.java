class Solution {
    public int lengthOfLongestSubstring(String s) {
        var left = 0;
        var right = 0;
        var set = new HashSet<Character>();
        var length = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
            } else {
                while (left < right && set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                } 

                set.add(s.charAt(right));
            }

            length = Math.max(length, right - left + 1);
            right++;
        }

        return length;
    }
}
