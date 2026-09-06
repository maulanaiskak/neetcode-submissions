class Solution {
    public int maxProfit(int[] prices) {
        var maxProfit = 0;
        var minPrice = 100;

        for (var price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}
