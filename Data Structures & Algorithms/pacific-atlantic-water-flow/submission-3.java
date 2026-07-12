class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var pacific = new boolean[heights.length][heights[0].length];
        var atlantic = new boolean[heights.length][heights[0].length];

        for (var i = 0; i < heights.length; i++) {
            dfs(heights, i, 0, pacific, 0);
        }

        for (var j = 0; j < heights[0].length; j++) {
            dfs(heights, 0, j, pacific, 0);
        }

        for (var i = 0; i < heights.length; i++) {
            dfs(heights, i, heights[0].length - 1, atlantic, 0);
        }

        for (var j = 0; j < heights[0].length; j++) {
            dfs(heights, heights.length - 1, j, atlantic, 0);
        }

        var result = new ArrayList<List<Integer>>();

        for (var i = 0; i < heights.length; i++) {
            for (var j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited, int prevHeight) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j]) {
            return;
        }

        if (heights[i][j] < prevHeight) {
            return;
        }

        visited[i][j] = true;

        dfs(heights, i + 1, j, visited, heights[i][j]);
        dfs(heights, i - 1, j, visited, heights[i][j]);
        dfs(heights, i, j + 1, visited, heights[i][j]);
        dfs(heights, i, j - 1, visited, heights[i][j]);
    }
}
