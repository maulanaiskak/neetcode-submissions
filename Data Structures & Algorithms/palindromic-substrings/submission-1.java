class Solution {
    public int countSubstrings(String s) {
        var result = 0;

        for (var i = 0; i < s.length(); i++) {
            var odd = expand(i, i, s);
            var even = expand(i, i+1, s);
            result += even + odd;
        }

        return result;
    }

    private int expand(int left, int right, String s) {
        var count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }
}
