class Solution {
    public boolean isValid(String s) {
        var opens = new ArrayDeque<Character>();

        for (var c : s.toCharArray()) {
            if (List.of('(', '{', '[').contains(c)) {
                opens.push(c);
            } else {
                if (opens.isEmpty()) {
                    return false;
                }

                var top = opens.pop();
                if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[') {
                    return false;
                }
            }
        }

        return opens.isEmpty();
    }
}
