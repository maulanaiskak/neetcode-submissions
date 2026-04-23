class Solution {
    public boolean isValid(String s) {
        var closeToOpen = new HashMap<Character, Character>();
        closeToOpen.put('}', '{');
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');

        var stack = new Stack<Character>();

        for (var c : s.toCharArray()) {
            if (closeToOpen.get(c) != null) {
                if (stack.isEmpty() || stack.pop() != closeToOpen.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
