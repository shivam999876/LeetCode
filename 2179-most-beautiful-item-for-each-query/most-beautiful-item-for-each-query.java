class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int[] res = new int[queries.length];
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        int maxBeauty = 0;
        int j = 0;
        for (int[] query : sortedQueries) {
            int price = query[0];
            int index = query[1];
                while (j < items.length && items[j][0] <= price) {
                maxBeauty = Math.max(maxBeauty, items[j][1]);
                j++;
            }
            res[index] = maxBeauty;
        }
        return res;
    }
}