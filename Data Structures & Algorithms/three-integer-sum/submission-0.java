class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		var result = new ArrayList<List<Integer>>();
		
		for (var i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue; 
			}
			
			var target = -nums[i];
			var left = i + 1;
			var right = nums.length - 1;

			while (left < right) {
				var sum = nums[left] + nums[right];

				if (sum == target) {
					result.add(List.of(nums[i], nums[left], nums[right]));
					left++;
					right--;

					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}

					while (left < right && nums[right] == nums[right + 1]) {
						right--; 
					}
				} else if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}

		return result;
    }
}
