class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var left = 1;
        var right = Arrays.stream(piles).max().getAsInt();
        
        while (left < right) {
            var mid = left + (right - left) / 2;
            
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        var totalHours = Arrays.stream(piles)
            .mapToLong(pile -> (pile + speed - 1) / speed)
            .sum();
        
        return totalHours <= h;
    }
}
