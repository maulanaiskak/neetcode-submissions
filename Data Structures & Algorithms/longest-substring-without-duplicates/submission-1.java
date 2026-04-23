class Solution {
    public int lengthOfLongestSubstring(String s) {
        var set = new HashSet<Character>();
        var left = 0;
        var current = 0;

        for (var right = 0; right < s.length(); right++) {
            var c = s.charAt(right);

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            if (right - left + 1 > current) {
                current = right - left + 1;
            }
        }

        return current;
    }
}
