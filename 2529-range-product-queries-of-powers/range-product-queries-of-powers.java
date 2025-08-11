class Solution {
    int MOD = (int)(1e9 + 7);
    public int[] productQueries(int n, int[][] queries) {
        List<Long> powers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) { 
                powers.add((long)(1 << i));
            }
        }
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            long product = 1;
            for (int i = start; i <= end; i++) {
                product = (product * powers.get(i)) % MOD;
            }
            result.add((int)product);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}