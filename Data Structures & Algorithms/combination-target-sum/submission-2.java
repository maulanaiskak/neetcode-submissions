class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, 0, 0, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, int sum, int target, List<Integer> current) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (sum > target) {
            return;
        }

        for (var i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i, sum + nums[i], target, current);
            current.removeLast();
        }
    }
}
