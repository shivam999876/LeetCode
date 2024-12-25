class Solution {
    public int orangesRotting(int[][] grid) {

        int rowLength = grid.length, colsLength = grid[0].length;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colsLength; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            boolean rotted = false;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < rowLength && newCol < colsLength &&
                            grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        q.add(new int[] { newRow, newCol });
                        rotted = true;
                    }
                }
            }
            if (rotted) {
                time++;
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colsLength; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}