class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }

        var left = 0;
        var right = s.length() - 1;
        s = s.toLowerCase();

        while (left < right) {
            while (left < right && !isAlphaNumeric(s.charAt(left))) {
                left++;
            } 

            while (left < right && !isAlphaNumeric(s.charAt(right))) {
                right--;
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
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}
