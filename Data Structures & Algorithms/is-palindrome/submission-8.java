class Solution {
    public boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;
        s = s.toLowerCase();

        while (left < right) {
            if (!isAlphaNumeric(s.charAt(left))) {
                left++;
                continue;
            }

            if (!isAlphaNumeric(s.charAt(right))) {
                right--;
                continue;
            }

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
