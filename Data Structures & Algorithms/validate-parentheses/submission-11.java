class Solution {
    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }

        var stack = new ArrayDeque<Character>();
        var open = List.of('(', '[', '{');

        for (var c : s.toCharArray()) {
            if (open.contains(c)){
                stack.offer(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if ((c == '}' && stack.peekLast() != '{')
                    || (c == ')' && stack.peekLast() != '(') 
                    || (c == ']' && stack.peekLast() != '[')) {
                        return false;
                } else {
                    stack.pollLast();
                }
            }
        }

        return stack.isEmpty();
    }
}
