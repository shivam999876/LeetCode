class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (point1, point2) -> {
            if (point1[0] == point2[0]) {
                return point2[1] - point1[1];
            }
            return point1[0] - point2[0];
        });
        int result = 0;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];   
            int bestY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];   
                if (y2 > y1) { 
                    continue;
                }
                if (y2 > bestY) {
                    result++;
                    bestY = y2;
                }
            }
        }
        return result;
    }
};