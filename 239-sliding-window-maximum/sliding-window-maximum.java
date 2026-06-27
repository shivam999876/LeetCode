class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;

        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            dq.addLast(i);

            if(dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            if(i >= k - 1){
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}