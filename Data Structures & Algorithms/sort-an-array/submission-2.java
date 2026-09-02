class Solution {
    public int[] sortArray(int[] nums) {
        /* Start sorting the whole array */
        mergeSort(nums, 0, nums.length - 1);

        /* Return the sorted array */
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        /* One element is already sorted */
        if (left >= right) {
            return;
        }

        /* Find the middle: [5,2,3,1] → [5,2] | [3,1] */
        var mid = (left + right) / 2;

        /* Sort the left half: [5,2] → [2,5] */
        mergeSort(nums, left, mid);

        /* Sort the right half: [3,1] → [1,3] */
        mergeSort(nums, mid + 1, right);

        /* Merge both sorted halves: [2,5] + [1,3] */
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        /* Temporary array for the merged result */
        var temp = new int[right - left + 1];

        /* Pointer to the left half */
        var i = left;

        /* Pointer to the right half */
        var j = mid + 1;

        /* Pointer to the temp array */
        var k = 0;

        /* Compare elements from both sorted halves */
        while (i <= mid && j <= right) {
            /* Take the smaller element */
            if (nums[i] <= nums[j]) {
                /* Copy from the left half */
                temp[k++] = nums[i++];
            } else {
                /* Copy from the right half */
                temp[k++] = nums[j++];
            }
        }

        /* Copy remaining elements from the left half */
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        /* Copy remaining elements from the right half */
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        /* Copy the sorted result back into nums */
        for (var x = 0; x < temp.length; x++) {
            /* Put temp element into its original position */
            nums[left + x] = temp[x];
        }
    }
}