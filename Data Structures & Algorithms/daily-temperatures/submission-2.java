class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var result = new int[temperatures.length];
        var stack = new ArrayDeque<Integer>();

        for (var i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                var idx = stack.pop();
                result[idx] = i - idx;
            }

            stack.push(i);
        }

        return result;
    }
}
