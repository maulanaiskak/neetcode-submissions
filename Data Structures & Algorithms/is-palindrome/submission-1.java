class Solution {
    public boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;
        s = s.toLowerCase();

        while (left <= right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
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
}
