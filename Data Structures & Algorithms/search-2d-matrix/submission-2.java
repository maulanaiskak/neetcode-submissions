class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var left = 0;
        var right = matrix.length * matrix[0].length - 1;

        while (left <= right) {
            var mid = (left + right) / 2;
            var row = mid / matrix[0].length;
            var col = mid % matrix[0].length;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
