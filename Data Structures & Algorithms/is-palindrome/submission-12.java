class Solution {
    public boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;

        while (left < right) {
            while (left < right && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }

            while (left < right && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }

            if (toLower(s.charAt(left)) != toLower(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= '0' && c <= '9') ||
               (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z');
    }

    private char toLower(char c) {
        return (c >= 'A' && c <= 'Z') ? (char) (c + 32) : c;
    }
}