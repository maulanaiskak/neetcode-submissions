class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // We need to track "how many ways can we reach sum S after processing i elements"
        // A single value is not enough because there are many possible sums at each step
        // So we use a Map: { sum -> number of ways to reach that sum }
        var state = new HashMap<Integer, Integer>();

        // Base case: before processing any element, there is exactly 1 way to reach sum=0
        // (do nothing, empty assignment)
        state.put(0, 1);

        // Process each element one by one
        for (var i = 0; i < nums.length; i++) {
            // We need a fresh map for this step because we cannot modify state
            // while iterating it — otherwise we'd read already-modified values
            var newState = new HashMap<Integer, Integer>();

            // Expand every possible sum from the previous step
            // We must expand ALL of them because we don't know which path leads to target yet
            for (var entry : state.entrySet()) {
                var sum = entry.getKey();
                var count = entry.getValue();

                // Each existing sum branches into two new sums:
                // option 1: assign + to nums[i]
                // option 2: assign - to nums[i]
                // count stays the same because we're just extending existing paths
                newState.merge(sum + nums[i], count, Integer::sum);
                newState.merge(sum - nums[i], count, Integer::sum);
            }

            // Replace old state with new state for next iteration
            state = newState;
        }

        // After processing all elements, state[target] = number of ways to reach target
        // getOrDefault handles the case where target is unreachable (returns 0)
        return state.getOrDefault(target, 0);
    }
}