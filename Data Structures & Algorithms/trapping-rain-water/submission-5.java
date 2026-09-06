class Solution {
    public int trap(int[] height) {
        var left = 0;
        var right = height.length - 1;
        var maxLeft = 0;
        var maxRight = 0;
        var volume = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    volume += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    volume += maxRight - height[right];
                }
                right--;
            }
        }

        return volume;
    }
}
