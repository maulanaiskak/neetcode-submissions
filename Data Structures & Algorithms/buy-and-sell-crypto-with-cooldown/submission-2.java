class Solution {
    public int maxProfit(int[] prices) {
        var len = prices.length;

        // At any day i, we can be in one of 3 states:
        // - hold     : we currently own a stock
        // - cooldown : we just sold today (cannot buy tomorrow)
        // - rest     : we don't own stock and are free to buy

        var hold = new int[len];
        var cooldown = new int[len];
        var rest = new int[len];

        // Base case (day 0):
        // - hold     : we bought on day 0, so profit starts negative
        // - cooldown : impossible to have sold on day 0 (nothing to sell), so 0
        // - rest     : we did nothing, profit is 0
        hold[0] = -prices[0];
        cooldown[0] = 0;
        rest[0] = 0;

        for (var i = 1; i < len; i++) {
            // hold[i]: we own stock at end of day i
            //   option 1 — we were holding yesterday and did nothing today    -> hold[i-1]
            //   option 2 — we were resting yesterday and bought today         -> rest[i-1] - prices[i]
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);

            // cooldown[i]: we just sold today
            //   only one option — we were holding yesterday and sold today    -> hold[i-1] + prices[i]
            //   (cooldown -> cooldown is not a valid transition)
            cooldown[i] = hold[i - 1] + prices[i];

            // rest[i]: we don't own stock and are free to buy tomorrow
            //   option 1 — we were in cooldown yesterday and waited today     -> cooldown[i-1]
            //   option 2 — we were resting yesterday and did nothing today    -> rest[i-1]
            rest[i] = Math.max(cooldown[i - 1], rest[i - 1]);
        }

        // At the last day, best profit is either:
        // - we sold on the last day (cooldown)
        // - we were resting on the last day (rest)
        // we never return hold[len-1] because holding unsold stock adds no profit
        return Math.max(cooldown[len - 1], rest[len - 1]);
    }
}