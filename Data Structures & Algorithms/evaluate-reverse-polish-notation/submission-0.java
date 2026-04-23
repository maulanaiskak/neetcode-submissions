class Solution {
    public int evalRPN(String[] tokens) {
        // set operator untuk O(1) lookup
        var operand = Set.of("+", "-", "*", "/");
        // stack nyimpen operand — saat ketemu operator, pop 2 teratas, hitung, push balik
        var stack = new ArrayDeque<Integer>();

        for (var token : tokens) {
            if (operand.contains(token)) {
                // pop urutan penting: num1 = kanan, num2 = kiri
                // karena LIFO — yang terakhir di-push adalah operand kanan
                var num1 = stack.pop(); // operand kanan
                var num2 = stack.pop(); // operand kiri
                var result = switch (token) {
                    case "+" -> num2 + num1; // num2 op num1, bukan sebaliknya
                    case "-" -> num2 - num1; // penting untuk - dan /
                    case "*" -> num2 * num1;
                    case "/" -> num2 / num1; // truncate toward zero, sesuai integer division Java
                    default -> throw new IllegalArgumentException("Unknown operator: " + token);
                };
                stack.push(result); // hasil operasi jadi operand baru untuk operasi berikutnya
            } else {
                stack.push(Integer.parseInt(token)); // token angka langsung push ke stack
            }
        }

        // sisa di stack pasti tepat 1 elemen — hasil akhir ekspresi
        return stack.pop();
    }
}