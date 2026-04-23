class Solution {
    public int maxProfit(int[] prices) {
        var minPrice = prices[0];
        var maxProfit = 0;

        for (var price : prices) {
            var profit = price - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (price < minPrice) {
                minPrice = price;
            }
        }

        return maxProfit;
    }
}
