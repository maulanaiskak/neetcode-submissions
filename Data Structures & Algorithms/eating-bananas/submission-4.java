class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var low = 1;
        var high = Arrays.stream(piles).max().getAsInt();
        var result = high;

        while (low <= high) {
            var mid = low + (high - low) / 2;

            if (isValid(piles, mid, h)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean isValid(int[] piles, int k, int h) {
        var total = 0;
        for (var pile : piles) {
            total += (pile + k - 1) / k;
        }

        return total <= h;
    }
}