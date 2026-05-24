class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0, nums, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int index, int[] nums, int remaining, List<Integer> current) {
        if (index >= nums.length || remaining < 0) {
            return;
        }

        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrack(index, nums, remaining - nums[index], current);
        current.remove(current.size() - 1);
        backtrack(index + 1, nums, remaining, current);
    }
}
