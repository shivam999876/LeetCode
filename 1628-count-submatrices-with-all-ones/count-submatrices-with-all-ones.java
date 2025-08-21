class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] histogram = new int[n];
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                histogram[j] = (mat[i][j] == 1) ? histogram[j] + 1 : 0;
            }
            Deque<int[]> st = new ArrayDeque<>();
            st.push(new int[]{-1, -1, 0}); 
            int currCount = 0;
            for (int j = 0; j < n; ++j) {
                while (st.peek()[0] >= histogram[j]) {
                    st.pop();
                }
                int[] top = st.peek();
                currCount = histogram[j] * (j - top[1]) + top[2];
                st.push(new int[]{histogram[j], j, currCount});
                count += currCount;
            }
        }
        return count;
    }
}