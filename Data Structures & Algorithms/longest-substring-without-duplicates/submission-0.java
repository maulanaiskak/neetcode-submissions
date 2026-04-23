class Solution {
    public int lengthOfLongestSubstring(String s) {
        // we can use sliding window for this with flexible size
        // every move we must check if there are duplicates
        // if there are duplicates, move left pointer to the right

        var maxLength = 0;
        var subString = new HashSet<Character>();
        var left = 0;
        var right = 0;

        while (right < s.length()) {
            var c = s.charAt(right);

            while(subString.contains(c)) {
                subString.remove(s.charAt(left));
                left++;
            }

            subString.add(c);
            maxLength = Math.max(maxLength, subString.size());
            right++;
        }

        return maxLength;
    }
}
