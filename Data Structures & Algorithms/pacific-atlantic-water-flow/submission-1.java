class Solution {
    private static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};  // up, down, left, right

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();
        
        // finding pacific flow
        boolean[][] pacific = new boolean[r][c];
        // finding atlantic flow
        boolean[][] atlantic = new boolean[r][c];
        
        for(int j = 0; j < c; j++) {
            dfs(0, j, pacific, heights, r, c);
            dfs(r - 1, j, atlantic, heights, r, c);
        }

        // for left most column
        for (int i = 0; i < r; i++) {
            dfs(i, 0, pacific, heights, r, c);
            dfs(i, c - 1, atlantic, heights, r, c);
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

    private void dfs (int row, int col, boolean[][] visited, int[][] heights, int r, int c) {
        // mark the node as visited
        visited[row][col] = true;

        for(int[] dir : DIRECTIONS) {
            int newRow = row + dir[0]; // 0 + -1 = -1
            int newCol = col + dir[1]; // 0 + 0 = 0

            if(newRow >= 0 && newRow < r        
                && newCol >= 0 && newCol < c
                && !visited[newRow][newCol]          // ✅ not visited
                && heights[newRow][newCol] >= heights[row][col]) { // ✅ uphill condition
                dfs(newRow, newCol, visited, heights, r, c);
            }
        }
    }
}
