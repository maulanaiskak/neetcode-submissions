class Solution {
    public int maxArea(int[] heights) {
        var left = 0;
        var right = heights.length - 1;
        var maxHeight = 0;

        while(left < right) {
            maxHeight = Math.max(maxHeight, (right - left) * Math.min(heights[left], heights[right]));
            
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxHeight;
    }
}
