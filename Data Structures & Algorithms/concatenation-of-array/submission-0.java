class Solution {
    public int[] getConcatenation(int[] nums) {
        var n = nums.length;
        var result = new int[n * 2];

        for (var i = 0; i < n; i++) {
            result[i] = nums[i];
            result[i + n] = nums[i];
        }

        return result;
    }
}