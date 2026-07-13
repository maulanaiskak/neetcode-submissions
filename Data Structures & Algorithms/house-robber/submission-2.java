class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
        return calculate(nums, nums.length - 1);
    }

    private int calculate(int[] nums, int idx) {
        if (idx < 0) {
            return 0;
        }

        if (idx == 0) {
            return nums[0];
        }

        if (idx == 1) {
            return Math.max(nums[0], nums[1]);
        }

        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        var result = Math.max(
            calculate(nums, idx - 1),
            calculate(nums, idx - 2) + nums[idx]
        );
        
        memo.put(idx, result);
        return result;
    }
}
