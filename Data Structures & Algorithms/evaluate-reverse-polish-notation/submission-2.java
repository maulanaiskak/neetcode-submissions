class Solution {
    public int evalRPN(String[] tokens) {
        var stack = new ArrayDeque<Integer>();

        for (var token : tokens) {
            switch (token) {
                case "+" , "-", "*", "/" -> {
                    var right = stack.pop();
                    var left = stack.pop();
                    stack.push(switch (token) {
                        case "+" -> left + right;
                        case "-" -> left - right;
                        case "*" -> left * right;
                        case "/" -> left / right;
                        default -> throw new IllegalArgumentException(token);
                    });
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}