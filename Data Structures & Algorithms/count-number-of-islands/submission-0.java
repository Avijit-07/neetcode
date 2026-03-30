class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0 ;

        int row = grid.length;
        int col = grid[0].length;

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(grid[r][c] == '1') {
                    dfs(grid, r, c);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if(nextRow >= 0 && nextRow < grid.length &&
                nextCol >= 0 && nextCol < grid[0].length &&
                grid[nextRow][nextCol] == '1') {
                dfs(grid, nextRow, nextCol);
            }
        }

    }
}
