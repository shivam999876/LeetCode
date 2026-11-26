class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        List<int[]> names = new ArrayList<>(); 
        names.add(nums);
        for (int half = 1; 2 * half <= n; half *= 2) {  
            long[] pairs = pairs(names.get(names.size() - 1), half);
            long[] ids = Arrays.stream(pairs).sorted().distinct().toArray(); 
            names.add(Arrays.stream(pairs).mapToInt(pair -> Arrays.binarySearch(ids, pair)).toArray());
        }
        int lo = 1, hi = n;  
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (found(names, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    private boolean found(List<int[]> names, int length) {  
        int k = 31 - Integer.numberOfLeadingZeros(length);  
        long[] pairs = pairs(names.get(k), length - (1 << k));
        Arrays.sort(pairs); 
        for (int i = 0; i < pairs.length; i++)
            if ((i == 0 || pairs[i - 1] != pairs[i]) && (i + 1 == pairs.length || pairs[i] != pairs[i + 1]))
                return true;
        return false;
    }
    private long[] pairs(int[] block, int shift) { 
        long[] pairs = new long[block.length - shift];
        for (int i = shift; i < block.length; i++)
            pairs[i - shift] = (long) block[i - shift] << 32 | block[i];
        return pairs;
    }
}