class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];

        // If the starting pixel already has the target color, no changes are needed
        if (initialColor == color) {
            return image;
        }

        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color; // Change color immediately upon entering queue

        // Direction vectors for moving Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check boundaries and if neighbor matches the original color
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && image[nr][nc] == initialColor) {
                    image[nr][nc] = color; // Modify color
                    queue.offer(new int[]{nr, nc}); // Enqueue neighbor
                }
            }
        }

        return image;
    }
}