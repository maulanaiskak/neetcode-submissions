class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var stack = new ArrayDeque<Integer>();
        var result = new int[temperatures.length];

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
