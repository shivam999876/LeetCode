class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int md = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int v = nums[i];
            map.putIfAbsent(v, new ArrayDeque<>());
            Deque<Integer> d = map.get(v);
            d.addLast(i);
            if(d.size() == 3){
                int f = d.peekFirst();
                int l = d.peekLast();
                md = Math.min(md, 2 * (l - f));
            }
            if(d.size() > 3){
                d.removeFirst();
                int f = d.peekFirst();
                int l = d.peekLast();
                md = Math.min(md, 2 * (l - f));
            }
        }
        return (md == Integer.MAX_VALUE) ? -1 : md;
    }
}