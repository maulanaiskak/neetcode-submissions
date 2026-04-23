class Solution {
    public void setZeroes(int[][] matrix) {
        var firstRowHasZero = false;
        var firstColHasZero = false;
        
        // Step 1: Check row 0 dan col 0
        for (var j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        
        for (var i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        
        // Step 2: Tandain pake row 0 dan col 0
        for (var i = 1; i < matrix.length; i++) {
            for (var j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Step 3: Set zeros based on marker
        for (var i = 1; i < matrix.length; i++) {
            for (var j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Step 4: Handle row 0 dan col 0
        if (firstRowHasZero) {
            for (var j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if (firstColHasZero) {
            for (var i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
