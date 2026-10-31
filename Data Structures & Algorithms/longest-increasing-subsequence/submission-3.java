class Solution {
    public int lengthOfLIS(int[] nums) {
        var dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (var i = 0; i < nums.length; i++) {
            for (var j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
