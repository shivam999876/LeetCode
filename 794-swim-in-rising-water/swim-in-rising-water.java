class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n][n];
        for (int[] row : result)
            Arrays.fill(row, Integer.MAX_VALUE);

        // Min-heap based on current time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        result[0][0] = grid[0][0];
        pq.offer(new int[]{grid[0][0], 0, 0}); // {time, i, j}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int i = curr[1];
            int j = curr[2];

            if (i == n - 1 && j == n - 1)
                return currTime;

            if (currTime > result[i][j])
                continue;

            for (int[] dir : directions) {
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if (i_ >= 0 && i_ < n && j_ >= 0 && j_ < n) {
                    int nextTime = Math.max(currTime, grid[i_][j_]);
                    if (nextTime < result[i_][j_]) {
                        result[i_][j_] = nextTime;
                        pq.offer(new int[]{nextTime, i_, j_});
                    }
                }
            }
        }

        return -1; // should never reach here
    }
}