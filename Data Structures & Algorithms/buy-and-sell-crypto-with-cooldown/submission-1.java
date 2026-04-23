class Solution {
    public int maxProfit(int[] prices) {
        var len = prices.length;
        var hold = new int[len];
        var cooldown = new int[len];
        var rest = new int[len];

        hold[0] = -prices[0];
        cooldown[0] = 0;
        rest[0] = 0;

        for (var i = 1; i < len; i++) {
            hold[i] = Math.max(hold[i-1], rest[i-1] - prices[i]);
            cooldown[i] = hold[i-1] + prices[i];
            rest[i] = Math.max(cooldown[i-1], rest[i-1]);
        }

        return Math.max(cooldown[len - 1], rest[len - 1]);
    }
}
