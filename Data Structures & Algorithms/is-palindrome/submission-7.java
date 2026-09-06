class Solution {
    public boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;
        s = s.toLowerCase();

        while (left < right) {
            if (left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
                continue;
            }

            if (left < right && !isAlphanumeric(s.charAt(right))) {
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

    public boolean isAlphanumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || 
               (ch >= '0' && ch <= '9');
    }
}
