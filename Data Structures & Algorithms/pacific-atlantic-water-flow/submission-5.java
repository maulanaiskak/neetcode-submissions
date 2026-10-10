class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var pacific = new boolean[heights.length][heights[0].length];
        var atlantic = new boolean[heights.length][heights[0].length];

        for (var row = 0; row < heights.length; row++) {
            dfs(heights, row, 0, pacific, 0);
        }

        for (var col = 0; col < heights[0].length; col++) {
            dfs(heights, 0, col, pacific, 0);
        }

        for (var row = 0; row < heights.length; row++) {
            dfs(heights, row, heights[0].length - 1, atlantic, 0);
        }

        for (var col = 0; col < heights[0].length; col++) {
            dfs(heights, heights.length - 1, col, atlantic, 0);
        }

        var result = new ArrayList<List<Integer>>();
        for (var row = 0; row < heights.length; row++) {
            for (var col = 0; col < heights[0].length; col++) {
                if (atlantic[row][col] && pacific[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length || visited[row][col] || heights[row][col] < prevHeight) {
            return;
        }

        visited[row][col] = true;

        dfs(heights, row + 1, col, visited, heights[row][col]);
        dfs(heights, row - 1, col, visited, heights[row][col]);
        dfs(heights, row, col + 1, visited, heights[row][col]);
        dfs(heights, row, col - 1, visited, heights[row][col]);
    }
}
