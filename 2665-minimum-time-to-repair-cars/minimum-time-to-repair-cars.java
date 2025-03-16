class Solution {
    private boolean canAssign(int[] ranks, long mid, int cars){
        long count = 0;
        for(int rank : ranks){
            count += Math.sqrt(mid / rank);
        }
        return count >= cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = Arrays.stream(ranks).min().getAsInt() * (long) cars * cars;
        long ans = 0;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(canAssign(ranks, mid, cars)){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}