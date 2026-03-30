class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int totalFreshFruits = 0; 
        int min = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        for(int r = 0 ; r < rows ; r++) {
            for (int c = 0; c < cols ; c++) {
                if(grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    totalFreshFruits++;
                }
            }
        }

        while(!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len ; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = dir[0] + pos[0];
                    int newCol = dir[1] + pos[1];

                    if(newRow >= 0 && newRow < rows
                        && newCol >=0 && newCol < cols
                        && grid[newRow][newCol] == 1) {
                            grid[newRow][newCol] = 2;
                            totalFreshFruits--;
                            queue.offer(new int[]{newRow, newCol});
                        }
                    
                }
            }
            if(!queue.isEmpty()) min++;

        }
        if(totalFreshFruits == 0) return min;
        else return -1;
    }
}
