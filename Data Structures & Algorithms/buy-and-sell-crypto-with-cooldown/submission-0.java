class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        var hold = -prices[0];
        var sold = 0;
        var rest = 0;

        for (int i = 1; i < prices.length; i++) {
            final int prevHold = hold;
            final int prevSold = sold;
            final int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]);
            sold = prevHold + prices[i];
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest);
    }
}
