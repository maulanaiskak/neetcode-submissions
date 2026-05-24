class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current) {
        if (index > nums.length) {
            return;
        }

        result.add(new ArrayList<>(current));

        for (var i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }

            current.add(nums[i]);
            backtrack(i + 1, nums, current);
            current.removeLast();
        }
    }
}
