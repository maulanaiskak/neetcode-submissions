class Solution {
    public int maxArea(int[] heights) {
        var max = 0;
        var left = 0;
        var right = heights.length - 1;

        while (left < right) {
            var area = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(max, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
