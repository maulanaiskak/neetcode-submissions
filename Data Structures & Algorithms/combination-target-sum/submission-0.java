class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        backtrack(0, nums, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, int remaining, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (remaining < 0) {
            return;
        }
        
        for (var i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i, nums, remaining - nums[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
