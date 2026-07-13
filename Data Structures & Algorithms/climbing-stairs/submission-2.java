class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        
        memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));

        return memo.get(n);
    }
}
