class Solution {
    public int largestRectangleArea(int[] heights) {
        var stack = new ArrayDeque<Integer>();
        var maxArea = 0;
        var newHeights = Arrays.copyOf(heights, heights.length + 1);

        for (var i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                var idx = stack.pop();
                var left = stack.isEmpty() ? -1 : stack.peek();
                var area = newHeights[idx] * (i - left - 1);
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
