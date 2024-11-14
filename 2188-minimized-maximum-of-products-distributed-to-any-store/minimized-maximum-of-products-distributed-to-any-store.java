class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 0;
        for(int q : quantities){
            right = Math.max(right, q);
        }
        int result = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canDistribute(mid, n, quantities)){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    private boolean canDistribute(int x, int n, int[] quantities){
        int stores = 0;
        for(int q : quantities){
            stores += (q + x - 1) / x;
        }
        return stores <= n;
    }
}