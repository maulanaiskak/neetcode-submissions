class Solution {
    public int maxProfit(int[] prices) {
        var minPrice = Integer.MAX_VALUE;
        var maxProfit = Integer.MIN_VALUE;

        for (var price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
