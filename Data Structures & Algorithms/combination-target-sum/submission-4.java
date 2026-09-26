class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int target, int idx, int sum, List<Integer> current) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (idx >= nums.length || sum > target) {
            return;
        }

        current.add(nums[idx]);
        backtrack(nums, target, idx, sum + nums[idx], current);

        current.removeLast();
        backtrack(nums, target, idx + 1, sum, current);
    }
}
