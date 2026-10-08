class Solution {
    private List<List<String>> result = new ArrayList();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int idx, List<String> current) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (var i = idx; i < s.length(); i++) {
            var substring = s.substring(idx, i + 1);
            if (!isPalindrome(substring)) {
                continue;
            }

            current.add(substring);
            backtrack(s, i + 1, current);
            current.removeLast();
        }
    }

    private boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
