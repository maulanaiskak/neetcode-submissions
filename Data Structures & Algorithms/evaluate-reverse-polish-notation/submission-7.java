class Solution {
    public int evalRPN(String[] tokens) {
        var operators = Set.of("+", "-", "*", "/");
        if (operators.contains(tokens[0])) {
            return -1;
        }

        var stack = new ArrayDeque<Integer>();
        for (var token : tokens) {
            if (operators.contains(token)) {
                var number2 = Integer.valueOf(stack.pop());
                var number1 = Integer.valueOf(stack.pop());
                
                if (token.equals("+")) {
                    stack.push(number1 + number2);
                } else if (token.equals("-")) {
                    stack.push(number1 - number2);
                } else if (token.equals("*")) {
                    stack.push(number1 * number2);
                } else {
                    stack.push(number1 / number2);
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
