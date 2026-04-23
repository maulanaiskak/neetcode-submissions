class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);
        current.remove(current.size() - 1);

        backtrack(index + 1, nums, current, result);
    }
}
