class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int INF = 2147483647;
        int steps = 1;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int[] pos = queue.poll();

                for (int[] dir : dirs) {
                    int newRow = dir[0] + pos[0];
                    int newCol = dir[1] + pos[1];

                    if(newRow >= 0 && newRow < rows
                        && newCol >= 0 && newCol < cols
                        && grid[newRow][newCol] == INF) {
                            grid[newRow][newCol] = steps;
                            queue.offer(new int[]{newRow, newCol});
                        }
                }
            }
            if(!queue.isEmpty()) steps++;
        }
    }
}
