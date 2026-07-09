class Solution {
    public int maxArea(int[] heights) {
        var left = 0;
        var right = heights.length - 1;
        var maxArea = 0;

        while (left < right) {
            var height = Math.min(heights[left], heights[right]);
            var width = right - left;
            var area = height * width;
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
