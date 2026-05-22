class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var left = 1;
        var right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            var mid = (left + right) / 2;

            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int speed, int target) {
        var sum = 0;

        for (var pile : piles) {
            sum += Math.ceil(pile/(double) speed);
        }

        return sum <= target;
    }
}
