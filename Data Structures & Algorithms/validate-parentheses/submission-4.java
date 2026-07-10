class Solution {
    private static Set<Character> OPEN_BRACKET = Set.of('{', '[', '(');

    public boolean isValid(String s) {
        var deque = new ArrayDeque<Character>();

        for (var c : s.toCharArray()) {
            if (OPEN_BRACKET.contains(c)) {
                deque.push(c); 
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                
                var top = deque.pop();
                var isInvalid = (top == '(' && c != ')') 
                                || (top == '[' && c != ']')
                                || (top == '{' && c != '}');

                if (isInvalid) {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
