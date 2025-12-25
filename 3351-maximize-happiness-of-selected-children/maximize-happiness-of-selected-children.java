class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long result = 0;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int hap : happiness){
            pq.offer(hap);
        }
        for(int i = 0; i < k; i++){
            int heap = pq.poll();
            result += Math.max(heap - count, 0);
            count++;
        }
        return result;
    }
}