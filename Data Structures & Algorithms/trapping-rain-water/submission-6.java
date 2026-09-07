class Solution {
    public int trap(int[] height) {
        var left = new int[height.length];
        for (var i = 0; i < height.length; i++) {
            if (i == 0) {
                left[i] = height[i];
            } else {
                left[i] = Math.max(left[i - 1], height[i]);
            }
        }

        var right = new int[height.length];
        for (var i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                right[i] = height[i];
            } else {
                right[i] = Math.max(right[i + 1], height[i]);
            }
        }

        var result = 0;
        for (var i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }
}
