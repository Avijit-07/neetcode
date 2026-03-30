class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();
        
        // finding pacific flow
        boolean[][] pacific = new boolean[r][c];
        
        // for top row
        for(int j = 0; j < c; j++) {
            dfs(0, j, pacific, heights);
        }

        // for left most column
        for (int i = 0; i < r; i++) {
            dfs(i, 0, pacific, heights);
        }

        // finding atlantic flow
        boolean[][] atlantic = new boolean[r][c];
        
        // for bottom row
        for(int j = 0; j < c; j++) {
            dfs(r - 1, j, atlantic, heights);
        }

        // for right most column
        for (int i = 0; i < r; i++) {
            dfs(i, c - 1, atlantic, heights);
        }

        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i,j));
                }
            }
        }
    return result;
    }

    private void dfs (int row, int col, boolean[][] visited, int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        // mark the node as visited
        visited[row][col] = true;

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}}; // up, down, left, right

        for(int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow >= 0 && newRow < r        // ✅ boundary check first
            && newCol >= 0 && newCol < c
            && !visited[newRow][newCol]          // ✅ not visited
            && heights[newRow][newCol] >= heights[row][col]) { // ✅ uphill condition
                dfs(newRow, newCol, visited, heights);
            }
        }
    }
}
