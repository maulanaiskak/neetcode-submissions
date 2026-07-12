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

        for (var i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i, nums, remaining - nums[i], current);
            current.removeLast();
        }
    }
}
