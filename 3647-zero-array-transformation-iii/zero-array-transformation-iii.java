class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        List<List<Integer>> starts = new ArrayList<>(n);
        for (int i = 0; i < n; i++) starts.add(new ArrayList<>());
        for (int[] qr : queries)
            starts.get(qr[0]).add(qr[1]);

        PriorityQueue<Integer> avail = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> active = new PriorityQueue<>();
        int chosen = 0;
        for (int i = 0; i < n; i++) {
            for (int r : starts.get(i))
                avail.offer(r);
            while (!active.isEmpty() && active.peek() < i)
                active.poll();
            int need = nums[i] - active.size();
            while (need-- > 0) {
                while (!avail.isEmpty() && avail.peek() < i)
                    avail.poll();
                if (avail.isEmpty())
                    return -1;
                active.offer(avail.poll());
                chosen++;
            }
        }
        return q - chosen;
    }
}