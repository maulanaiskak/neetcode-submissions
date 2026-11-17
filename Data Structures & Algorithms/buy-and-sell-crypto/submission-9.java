class Solution {
    public int maxProfit(int[] prices) {
        var max = 0;
        var minPrice = Integer.MAX_VALUE;

        for (var price : prices) {
            max = Math.max(max, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return max;
    }
}
