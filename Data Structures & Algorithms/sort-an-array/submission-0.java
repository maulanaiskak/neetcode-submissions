class Solution {
    public int[] sortArray(int[] nums) {
        /*
         * Example:
         * nums = [5, 2, 3, 1]
         *
         * Split:
         * [5, 2, 3, 1]
         *     ↓
         * [5, 2] [3, 1]
         *
         * Then sort each half recursively.
         */
        mergeSort(nums, 0, nums.length - 1);

        /*
         * After all merges:
         * nums = [1, 2, 3, 5]
         */
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        /*
         * Stop when there is only one element.
         *
         * Example:
         * [5] → already sorted
         * [2] → already sorted
         */
        if (left >= right) {
            return;
        }

        /*
         * Find the middle.
         *
         * Example:
         * left = 0
         * right = 3
         * mid = 1
         *
         * [5, 2, 3, 1]
         *     ↓
         * [5, 2] [3, 1]
         */
        var mid = (left + right) / 2;

        /*
         * Sort the left half.
         *
         * [5, 2]
         *   ↓
         * [5] [2]
         *   ↓
         * [2, 5]
         */
        mergeSort(nums, left, mid);

        /*
         * Sort the right half.
         *
         * [3, 1]
         *   ↓
         * [3] [1]
         *   ↓
         * [1, 3]
         */
        mergeSort(nums, mid + 1, right);

        /*
         * Both halves are now sorted:
         *
         * [2, 5] + [1, 3]
         *
         * Merge them:
         * [1, 2, 3, 5]
         */
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        /*
         * Create temporary array for the merged result.
         *
         * Example:
         * [2, 5] + [1, 3]
         *
         * temp = [_, _, _, _]
         */
        var temp = new int[right - left + 1];

        /*
         * i points to the first element of the left half.
         *
         * [2, 5]
         *  ↑
         *  i
         */
        var i = left;

        /*
         * j points to the first element of the right half.
         *
         * [1, 3]
         *  ↑
         *  j
         */
        var j = mid + 1;

        /*
         * k points to where we insert into temp.
         */
        var k = 0;

        /*
         * Compare both halves and take the smaller element.
         *
         * [2, 5]    [1, 3]
         *  ↑          ↑
         *  i          j
         *
         * 2 vs 1 → take 1
         * temp = [1, _, _, _]
         *
         * 2 vs 3 → take 2
         * temp = [1, 2, _, _]
         *
         * 5 vs 3 → take 3
         * temp = [1, 2, 3, _]
         *
         * Right half is finished.
         */
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        /*
         * Copy remaining elements from the left half.
         *
         * Example:
         * [2, 5] [1, 3]
         *       ↑
         *       5 is remaining
         *
         * temp = [1, 2, 3, 5]
         */
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        /*
         * Copy remaining elements from the right half.
         *
         * Usually one side will have remaining elements,
         * because the main loop stops when one side is exhausted.
         */
        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        /*
         * Copy the sorted result back into nums.
         *
         * Before:
         * nums = [5, 2, 3, 1]
         *
         * After:
         * nums = [1, 2, 3, 5]
         */
        for (var x = 0; x < temp.length; x++) {
            nums[left + x] = temp[x];
        }
    }
}