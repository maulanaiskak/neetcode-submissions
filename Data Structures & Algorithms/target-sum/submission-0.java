class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        var state = new HashMap<Integer, Integer>();
        state.put(0, 1);

        for (var i = 0; i < nums.length; i++) {
            var newState = new HashMap<Integer, Integer>();
            for (var entry : state.entrySet()) {
                var sum = entry.getKey();
                var count = entry.getValue();
                newState.merge(sum + nums[i], count, Integer::sum);
                newState.merge(sum - nums[i], count, Integer::sum);
            }
            state = newState;
        }

        return state.getOrDefault(target, 0);
    }
}
