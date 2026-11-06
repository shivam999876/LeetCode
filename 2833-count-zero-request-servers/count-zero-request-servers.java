class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int[][] reqs = Arrays.copyOf(logs, logs.length + 1);
        reqs[logs.length] = new int[] {0, Integer.MAX_VALUE};  
        Arrays.sort(reqs, 0, logs.length, Comparator.comparingInt(r -> r[1])); 
        Integer[] order = new Integer[queries.length];
        Arrays.setAll(order, i -> i);
        Arrays.sort(order, Comparator.comparingInt(i -> queries[i]));  

        int[] cnt = new int[n + 1], ans = new int[queries.length];  
        int busy = 0, lo = 0, hi = 0;  
        for (int i : order) {
            int q = queries[i];
            for (; reqs[hi][1] <= q; hi++) 
                if (cnt[reqs[hi][0]]++ == 0) busy++;
            for (; reqs[lo][1] < q - x; lo++)
                if (--cnt[reqs[lo][0]] == 0) busy--;
            ans[i] = n - busy;
        }
        return ans;
    }
}