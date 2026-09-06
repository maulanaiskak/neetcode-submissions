class Solution {
    public int maxArea(int[] heights) {
        var left = 0;
        var right = heights.length - 1;
        var maxArea = 0;

        while (left < right) {
            var minHeight = Math.min(heights[left], heights[right]);
            var area = (right - left) * minHeight;
            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
