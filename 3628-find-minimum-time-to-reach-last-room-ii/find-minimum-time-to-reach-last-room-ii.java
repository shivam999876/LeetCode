class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] minTime = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<int[]> minh = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minh.offer(new int[]{0, 0, 0, 0});
        minTime[0][0] = 0;

        while (!minh.isEmpty()) {
            int[] top = minh.poll();
            int x = top[0], y = top[1], currTime = top[2], alt = top[3];

            if (currTime > minTime[x][y]) continue;
            if (x == n - 1 && y == m - 1) return currTime;

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int waitTime = Math.max(moveTime[nx][ny] - currTime, 0);
                int moveCost = (alt % 2 == 0 ? 1 : 2);
                int nextTime = currTime + waitTime + moveCost;

                if (nextTime < minTime[nx][ny]) {
                    minTime[nx][ny] = nextTime;
                    minh.offer(new int[]{nx, ny, nextTime, alt + 1});
                }
            }
        }

        return -1;
    }
}