class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        var result = new ArrayList<List<Integer>>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
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
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }

            current.add(nums[i]);
            backtrack(i + 1, nums, remaining - nums[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
