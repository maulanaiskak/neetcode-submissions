class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> subset) {
        result.add(new ArrayList<>(subset));

        for (var j = i; j < nums.length; j++) {
            subset.add(nums[j]);
            backtrack(nums, j + 1, subset);
            subset.removeLast();
        }
    }
}
