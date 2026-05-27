class Solution {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int index, List<String> current) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (var i = index; i < s.length(); i++) {
            if (isPalindrome(s.substring(index, i + 1))) {
                current.add(s.substring(index, i + 1));
                backtrack(s, i + 1, current);
                current.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        var left = 0;
        var right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
