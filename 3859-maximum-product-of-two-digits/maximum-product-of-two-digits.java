class Solution {
    public int maxProduct(int n) {
        int[] c = new int[10];
        List<Integer> ds = new ArrayList<>();
        while (n > 0) {
            int d = n % 10;
            c[d]++;
            ds.add(d);
            n /= 10;
        }
        int mP = 0;
        int size = ds.size();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int d1 = ds.get(i);
                int d2 = ds.get(j);
                if (i == j && c[d1] < 2) continue;  
                mP = Math.max(mP, d1 * d2);
            }
        }
        return mP;
    }
}