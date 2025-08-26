class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = 0;
        int maxArea = 0;

        for (int i = 0; i < dimensions.length; i++) {
            int l = dimensions[i][0];
            int w = dimensions[i][1];

            int diag = l * l + w * w;
            int area = l * w;

            if (diag > maxDiag) {
                maxDiag = diag;
                maxArea = area;
            } else if (diag == maxDiag) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}