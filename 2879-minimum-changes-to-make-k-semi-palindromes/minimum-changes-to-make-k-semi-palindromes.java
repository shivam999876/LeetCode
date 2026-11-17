class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length(), inf = Integer.MAX_VALUE / 2;
        int[][] cost = new int[n + 1][n + 1];  
        for (int[] row : cost)
            Arrays.fill(row, inf);
        for (int d = 1; 2 * d <= n; d++)
            for (int length = 2 * d; length <= n; length += d)  
                for (int i = 0, j = length; j <= n; i++, j++)
                    cost[i][j] = Math.min(cost[i][j], peel(s, i, j, d));
        int[] best = new int[n + 1];  
        Arrays.fill(best, inf);
        best[0] = 0;
        for (int pieces = 1; pieces < k; pieces++) {  
            int[] next = new int[n + 1];
            Arrays.fill(next, inf);
            for (int j = 2 * pieces; j <= n - 2 * (k - pieces); j++)  
                next[j] = extend(best, cost, j);
            best = next;
        }
        return extend(best, cost, n);  
    }
    private int peel(String s, int i, int j, int d) {  
        int changes = 0;
        for (; j - i > d; i += d, j -= d)
            for (int t = 0; t < d; t++)
                if (s.charAt(i + t) != s.charAt(j - d + t))
                    changes++;
        return changes;
    }
    private int extend(int[] best, int[][] cost, int j) {  
        return IntStream.rangeClosed(0, j - 2).map(i -> best[i] + cost[i][j]).min().getAsInt();
    }
}