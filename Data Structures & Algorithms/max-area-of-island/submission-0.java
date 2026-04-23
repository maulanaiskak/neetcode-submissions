class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        var maxArea = 0;

        for (var row = 0; row < grid.length; row++) {
            for (var col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, calculateArea(grid, row, col));
                }
            }
        }

        return maxArea;
    }

    private int calculateArea(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        return 1 + calculateArea(grid, row + 1, col)
            + calculateArea(grid, row - 1, col)
            + calculateArea(grid, row, col + 1)
            + calculateArea(grid, row, col - 1);
    }
}
