class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // treat matrix sebagai 1D sorted array, total elemen = rows * cols
        // index valid: 0 sampai rows*cols-1
        var left = 0;
        var right = matrix.length * matrix[0].length - 1;

        while (left <= right) {
            var mid = left + (right - left) / 2; // hindari integer overflow vs (left+right)/2

            // konversi 1D index ke 2D:
            // row = mid / cols → berapa row penuh yang udah dilewati
            // col = mid % cols → sisa setelah skip row-row penuh = posisi kolom
            var row = mid / matrix[0].length;
            var col = mid % matrix[0].length;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1; // target ada di kanan, buang setengah kiri
            } else {
                right = mid - 1; // target ada di kiri, buang setengah kanan
            }
        }

        // left > right → target ga ada di matrix
        return false;
    }
}