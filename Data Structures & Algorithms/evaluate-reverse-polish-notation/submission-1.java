class Solution {
    public int evalRPN(String[] tokens) {
        var operator = Set.of("+", "-", "*", "/");
        var stack = new ArrayDeque<Integer>();

        for (var token : tokens) {
            if (operator.contains(token)) {
                if (stack.size() >= 2) {
                    var right = stack.pop();
                    var left = stack.pop();

                    if ("+".equals(token)) {
                        stack.push(left + right);
                    } else if ("-".equals(token)) {
                        stack.push(left - right);
                    } else if ("*".equals(token)) {
                        stack.push(left * right);
                    } else if ("/".equals(token)) {
                        stack.push(left / right);
                    }
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
