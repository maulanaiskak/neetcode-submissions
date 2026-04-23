class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Start DFS from index 0 with current sum = 0
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int index, int currentSum, int target) {
        // Base case: we've assigned +/- to all elements
        // if the final sum matches target, this path is valid -> count it as 1
        // otherwise this path is invalid -> count it as 0
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        // We use DFS because:
        // - at each element, there are exactly 2 choices: + or -
        // - this forms a binary tree of decisions
        // - we need to reach the leaf (all elements processed) to know if a path is valid
        // - DFS naturally explores one full path at a time, then backtracks to try the other
        //
        //                  sum=0
        //                 /     \
        //            +1=1        -1=-1
        //            /  \        /   \
        //         +2=3 -2=-1  +2=1  -2=-3
        //
        // each leaf is checked against target, valid ones contribute 1 to the total count

        // explore both branches and sum up valid paths from each
        int plus = dfs(nums, index + 1, currentSum + nums[index], target);
        int minus = dfs(nums, index + 1, currentSum - nums[index], target);

        // total valid paths = valid paths from + branch + valid paths from - branch
        return plus + minus;
    }
}