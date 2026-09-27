class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int target, int start, int sum, List<Integer> current) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (start >= nums.length || sum > target) {
            return;
        }

        for (var i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            if (sum + nums[i] > target) {
                break;
            }

            current.add(nums[i]);
            backtrack(nums, target, i + 1, sum + nums[i], current);
            current.removeLast();
        }
    }
}
