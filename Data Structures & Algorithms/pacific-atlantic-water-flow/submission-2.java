class Solution {
    private static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};  // up, down, left, right

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;

        // find the water flows from top and bottom
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < cols; i++) {
            // for pacific flow row will always be 0
            dfs(0, i, pacific, heights, rows, cols);

            // for atlantic flow row will be (rows - 1)
            dfs(rows - 1, i, atlantic, heights, rows, cols);
        }

        // find the water flows from left and right
        for (int j = 0; j < rows; j++) {
            // for pacific flow col will always be 0
            dfs(j, 0, pacific, heights, rows, cols);

            // for atlantic flow col will always be (cols - 1)
            dfs(j, cols - 1, atlantic, heights, rows, cols);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] visited, int[][] heights, 
                    int totalRows, int totalCols) {
        visited[row][col] = true;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow >= 0 && newRow < totalRows
                && (newCol >= 0 && newCol < totalCols)
                && !visited[newRow][newCol]
                && heights[newRow][newCol] >= heights[row][col]) {
                    dfs(newRow, newCol, visited, heights, totalRows, totalCols);
                }
        }

    }
}
