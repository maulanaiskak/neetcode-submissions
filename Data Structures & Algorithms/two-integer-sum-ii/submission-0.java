class Solution {
    public int[] twoSum(int[] numbers, int target) {
		var left = 0;
		var right = numbers.length - 1;
		
		while (left < right) {
			final var sum = numbers[left] + numbers[right];
			
			if (sum == target) {
				return new int[]{left + 1, right + 1};
			}
			
			if (sum > target) {
				right--;
			} else {
				left++;
			}
		}
		
		return new int[]{-1, -1};
    }
}
